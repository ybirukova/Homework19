package com.example.homework19.model.ui.movies_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework19.R
import com.example.homework19.model.models.MovieData
import com.example.homework19.model.presenter.MoviePresenter
import com.example.homework19.model.presenter.MoviePresenterImpl

class MovieFragment : Fragment(), MovieView {
    private var itemCLick: ((String, String) -> Unit)? = null
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
    }

    override fun showMovies(movies: List<MovieData>) {
        val adapter = MovieAdapter(movies, itemCLick)
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
        fun newInstance(itemClick: (String, String) -> Unit): MovieFragment {
            val fragment = MovieFragment()
            fragment.itemCLick = itemClick
            return fragment
        }
    }
}