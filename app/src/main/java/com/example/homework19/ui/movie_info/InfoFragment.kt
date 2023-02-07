package com.example.homework19.ui.movie_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.homework19.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InfoFragment : Fragment() {

    private val args: InfoFragmentArgs by navArgs()
    private val viewModel by viewModels<InfoViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_info, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getMovieById(args.movieId)
        viewModel.liveData.observe(viewLifecycleOwner) {
            val about = view.findViewById<TextView>(R.id.tv_fragment_about)
            val title = view.findViewById<TextView>(R.id.tv_fragment_title)

            /*** если операция выполняется в другом потоке, about.text = it.about необходимо писать следующим образом:
             * т.к. это действие должно производится в главном потоке (иначе будет ошибка)
             *
            val myRunnable = Runnable{
                Thread.sleep(2000)
                about.post{
                    about.text = it.about
                }
            }
            val thread = Thread(myRunnable)
            thread.start()
             */
            about.text = it.about
            title.text = it.name
        }
    }
}