package com.example.homework19.ui.movies_list

import com.example.homework19.model.models.MovieData

interface MovieView {

    fun showMovies(server: List<MovieData>)
}