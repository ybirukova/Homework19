package com.example.homework19.ui.movie_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.homework19.databinding.FragmentInfoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InfoFragment : Fragment() {

    private val args: InfoFragmentArgs by navArgs()
    private val viewModel by viewModels<InfoViewModel>()
    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInfoBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getMovieById(args.movieId)
        viewModel.liveData.observe(viewLifecycleOwner) {
            val about = binding.tvFragmentAbout
            val title = binding.tvFragmentTitle

            about.text = it.about
            title.text = it.name
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}