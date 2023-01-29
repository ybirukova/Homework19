package com.example.homework19.ui.unpopular_movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework19.R
import com.example.homework19.domain.models.MovieData
import com.example.homework19.ui.MovieAdapter
import com.example.homework19.ui.unpopular_movies.presenter.UnpopularMoviesPresenter
import com.example.homework19.ui.unpopular_movies.presenter.UnpopularMoviesPresenterImpl

class UnpopularMovieFragment : Fragment(), UnpopularMovieView {

    private var itemCLick: ((String, String) -> Unit)? = null
    private var presenter: UnpopularMoviesPresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_unpopular_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = UnpopularMoviesPresenterImpl(this)

        presenter?.getUnpopularMovies()
    }

    override fun showUnpopularMovies(movies: List<MovieData>) {
        val adapter = MovieAdapter(movies, itemCLick)
        val recycler = view?.findViewById<RecyclerView>(R.id.rv_unpopular_movie_list)
        recycler?.adapter = adapter
        recycler?.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        presenter?.onClear()
    }

    companion object {
        fun newInstance(): UnpopularMovieFragment {
            return UnpopularMovieFragment()
        }
    }
}