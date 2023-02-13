package com.example.homework19.ui.all_movies

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isVisible
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
        viewModel.getFavoriteMovie()

        val recycler = view.findViewById<RecyclerView>(R.id.rv_movie_list)
        val progressBar = view.findViewById<ProgressBar>(R.id.progress_bar)
        val unpopularButton = view.findViewById<Button>(R.id.button_show_unpopular_movies)
        val favoriteMovieButton = view.findViewById<Button>(R.id.button_show_favorite_movie)

        viewModel.loadingLiveData.observe(viewLifecycleOwner) { show ->
            progressBar.isVisible = show
            recycler.isVisible = show.not()
        }

        viewModel.errorLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }

        viewModel.liveData.observe(viewLifecycleOwner) {
            val adapter = MovieAdapter(it, itemClick)
            recycler?.adapter = adapter
            recycler?.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }

        favoriteMovieButton.setOnClickListener{
        viewModel.favoriteMovieLiveData.observe(viewLifecycleOwner){movie->

            Log.d("PRINT", "${movie?.name}")
                if (movie != null) {
                    Toast.makeText(requireContext(),"Favorite movie: ${movie.name}",Toast.LENGTH_SHORT).show()
                }
            }
        }

        unpopularButton?.setOnClickListener {
            val action = MovieFragmentDirections.actionFragmentMoviesToFragmentUnpopularMovies()
            findNavController().navigate(action)
        }
    }
}