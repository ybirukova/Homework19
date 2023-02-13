package com.example.homework19.data

import com.example.homework19.data.mappers.MovieMapper
import com.example.homework19.domain.models.MovieData
import com.example.homework19.domain.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val service: Server,
    private val mapperMovie: MovieMapper,
) : MoviesRepository {

    override suspend fun getMovies(): List<MovieData> =
        withContext(Dispatchers.IO) { service.getMovies().map { mapperMovie(it) } }
}