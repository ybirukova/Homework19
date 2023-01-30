package com.example.homework19.ui.all_movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework19.R
import com.example.homework19.domain.models.MovieData
import com.example.homework19.ui.MovieAdapter
import com.example.homework19.ui.all_movies.presenter.MoviePresenter
import com.example.homework19.ui.all_movies.presenter.MoviePresenterImpl

class MovieFragment : Fragment(), MoviesView {

    private var unpopularButton: Button? = null
    private var onItemCLick: ((String, String) -> Unit)? = null
    private var onUnpopularButtonCLick: (() -> Unit)? = null
    private var presenter: MoviePresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = MoviePresenterImpl(this)
        presenter?.getMovies()

        unpopularButton = view.findViewById(R.id.button_show_unpopular_movies)
        unpopularButton?.setOnClickListener {
            onUnpopularButtonCLick?.invoke()
        }
    }

    override fun showMovies(movies: List<MovieData>) {
        val adapter = MovieAdapter(movies, onItemCLick)
        val recycler = view?.findViewById<RecyclerView>(R.id.rv_movie_list)
        recycler?.adapter = adapter
        recycler?.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        presenter?.onClear()
    }

    companion object {

        fun newInstance(
            onItemClick: (String, String) -> Unit,
            onUnpopularButtonClick: () -> Unit
        ): MovieFragment {
            val fragment = MovieFragment()
            fragment.onItemCLick = onItemClick
            fragment.onUnpopularButtonCLick = onUnpopularButtonClick
            return fragment
        }
    }
}