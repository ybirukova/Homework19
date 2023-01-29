package com.example.homework19.ui.all_movies

import com.example.homework19.domain.models.MovieData

interface MoviesView {

    fun showMovies(server: List<MovieData>)
}