package com.example.homework19.ui.all_movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework19.databinding.FragmentMoviesBinding
import com.example.homework19.ui.MovieAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : Fragment() {

    private val viewModel by viewModels<MovieViewModel>()
    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!

    private val itemClick: (Int) -> Unit = { id ->
        val action =
            MovieFragmentDirections.actionFragmentMoviesToFragmentInfo(id)
        findNavController().navigate(action)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.movieViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.getAllMovies()
        viewModel.getFavoriteMovie()

        val unpopularButton = binding.buttonShowUnpopularMovies
        val favoriteMovieButton = binding.buttonShowFavoriteMovie
        val recycler = binding.rvMovieList

        viewModel.errorLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }

        viewModel.liveData.observe(viewLifecycleOwner) {
            val adapter = MovieAdapter(it, itemClick)
            recycler.adapter = adapter
            recycler.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }

        favoriteMovieButton.setOnClickListener {
            viewModel.favoriteMovieLiveData.observe(viewLifecycleOwner) { movie ->
                if (movie != null) {
                    Toast.makeText(
                        requireContext(),
                        "Favorite movie: ${movie.name}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        unpopularButton.setOnClickListener {
            val action = MovieFragmentDirections.actionFragmentMoviesToFragmentUnpopularMovies()
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}