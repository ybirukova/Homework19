package com.example.homework19.ui.unpopular_movies.presenter

import com.example.homework19.domain.use_cases.GetUnpopularMoviesUseCase
import com.example.homework19.ui.unpopular_movies.UnpopularMovieView

class UnpopularMoviesPresenterImpl(private var view: UnpopularMovieView?) :
    UnpopularMoviesPresenter {

    private val useCase = GetUnpopularMoviesUseCase()

    override fun getUnpopularMovies() {
        view?.showUnpopularMovies(useCase())
    }

    override fun onClear() {
        view = null
    }

}