package com.example.homework19.domain.use_cases

import android.graphics.Movie
import com.example.homework19.data.MoviesRepositoryImpl
import com.example.homework19.domain.models.MovieData
import com.example.homework19.domain.repository.MoviesRepository

class GetAllMoviesUseCase {

    private val repository: MoviesRepository = MoviesRepositoryImpl()

    operator fun invoke(): List<MovieData> = repository.getMovies()
}