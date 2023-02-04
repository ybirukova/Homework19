package com.example.homework19.ui.all_movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework19.R
import com.example.homework19.ui.MovieAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : Fragment() {

    private var unpopularButton: Button? = null
    private val viewModel by viewModels<MovieViewModel>()

    private val itemClick: (Int) -> Unit = { id ->
        val action =
            MovieFragmentDirections.actionFragmentMoviesToFragmentInfo(id)
        findNavController().navigate(action)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAllMovies()

        viewModel.liveData.observe(viewLifecycleOwner) {
            val adapter = MovieAdapter(it, itemClick)
            val recycler = view.findViewById<RecyclerView>(R.id.rv_movie_list)
            recycler?.adapter = adapter
            recycler?.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }

        unpopularButton = view.findViewById(R.id.button_show_unpopular_movies)
        unpopularButton?.setOnClickListener {
            val action = MovieFragmentDirections.actionFragmentMoviesToFragmentUnpopularMovies()
            findNavController().navigate(action)
        }
    }
}