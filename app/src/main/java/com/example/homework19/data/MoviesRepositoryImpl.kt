package com.example.homework19.data

import com.example.homework19.data.mappers.MovieMapper
import com.example.homework19.domain.models.MovieData
import com.example.homework19.domain.repository.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val service: Server,
    private val mapper: MovieMapper
) : MoviesRepository {

    override fun getMovies(): List<MovieData> = service.getMovies().map { mapper(it) }
}