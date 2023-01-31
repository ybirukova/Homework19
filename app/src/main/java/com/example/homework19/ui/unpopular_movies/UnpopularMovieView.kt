package com.example.homework19.ui.unpopular_movies

import com.example.homework19.domain.models.MovieData

interface UnpopularMovieView {

    fun showUnpopularMovies(movies: List<MovieData>)
}