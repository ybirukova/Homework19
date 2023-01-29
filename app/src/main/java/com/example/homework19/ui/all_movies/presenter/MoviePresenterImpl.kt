package com.example.homework19.ui.all_movies.presenter

import com.example.homework19.ui.all_movies.MoviesView
import com.example.homework19.domain.repository.MoviesRepository
import com.example.homework19.Server
import com.example.homework19.domain.use_cases.GetAllMoviesUseCase

class MoviePresenterImpl(private var view: MoviesView?) : MoviePresenter {

    private val useCase = GetAllMoviesUseCase()

    override fun getMovies() {
        view?.showMovies(useCase())
    }

    override fun onClear() {
        view = null
    }
}