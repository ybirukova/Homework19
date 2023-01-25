package com.example.homework19.model.models

import com.example.homework19.model.ui.MovieData

interface MovieRepository {
    fun getMovies(): List<MovieData>
}