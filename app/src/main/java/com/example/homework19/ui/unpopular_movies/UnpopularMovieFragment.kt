package com.example.homework19.ui.unpopular_movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework19.R
import com.example.homework19.ui.MovieAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UnpopularMovieFragment : Fragment() {

    private val viewModel by viewModels<UnpopularMovieViewModel>()
    private val itemClick: (Int) -> Unit = { id ->
        val action =
            UnpopularMovieFragmentDirections.actionFragmentUnpopularMoviesToFragmentInfo(id)
        findNavController().navigate(action)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_unpopular_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getUnpopularMovies()

        viewModel.liveData.observe(viewLifecycleOwner) {
            val adapter = MovieAdapter(it, itemClick)
            val recycler = view.findViewById<RecyclerView>(R.id.rv_unpopular_movie_list)
            recycler?.adapter = adapter
            recycler?.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }
}