package com.example.homework19.data

import com.example.homework19.Server
import com.example.homework19.data.mappers.MovieMapper
import com.example.homework19.domain.models.MovieData
import com.example.homework19.domain.repository.MoviesRepository

class MoviesRepositoryImpl : MoviesRepository {

    val mapper = MovieMapper()
    override fun getMovies(): List<MovieData> = Server.getMovies().map { mapper(it) }
}