package com.example.homework19.domain.repository

import com.example.homework19.domain.models.MovieData

interface MoviesRepository {

    fun getMovies(): List<MovieData>
}