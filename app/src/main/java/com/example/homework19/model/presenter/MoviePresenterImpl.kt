package com.example.homework19.model.presenter

import com.example.homework19.model.ui.movies_list.MovieView
import com.example.homework19.model.models.MovieRepository
import com.example.homework19.model.Server

class MoviePresenterImpl(private var view: MovieView?) : MoviePresenter {

    private val repository: MovieRepository = Server

    override fun getMovies() {
        view?.showMovies(repository.getMovies())
    }

    override fun onClear() {
        view = null
    }
}