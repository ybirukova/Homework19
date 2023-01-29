package com.example.homework19.model.models

interface MovieRepository {

    fun getMovies(): List<MovieData>
}