package com.example.homework19.domain.use_cases

import com.example.homework19.data.MoviesRepositoryImpl
import com.example.homework19.domain.models.MovieData
import com.example.homework19.domain.repository.MoviesRepository

class GetUnpopularMoviesUseCase {

    private val repository: MoviesRepository = MoviesRepositoryImpl()

    operator fun invoke(): List<MovieData> =
        repository.getMovies().filter { it.rating < POPULAR_RATING }

    companion object {
        private const val POPULAR_RATING = 8.0
    }
}