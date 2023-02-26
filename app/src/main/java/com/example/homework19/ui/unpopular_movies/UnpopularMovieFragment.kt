package com.example.homework19.ui.unpopular_movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework19.databinding.FragmentUnpopularMoviesBinding
import com.example.homework19.ui.MovieAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UnpopularMovieFragment : Fragment() {

    private val viewModel by viewModels<UnpopularMovieViewModel>()
    private var _binding: FragmentUnpopularMoviesBinding? = null
    private val binding get() = _binding!!

    private val itemClick: (Int) -> Unit = { id ->
        val action =
            UnpopularMovieFragmentDirections.actionFragmentUnpopularMoviesToFragmentInfo(id)
        findNavController().navigate(action)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentUnpopularMoviesBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getUnpopularMovies()
        val recycler = binding.rvUnpopularMovieList

        viewModel.liveData.observe(viewLifecycleOwner) {
            val adapter = MovieAdapter(it, itemClick)
            recycler.adapter = adapter
            recycler.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}