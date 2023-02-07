package com.example.homework19.domain.use_cases

import com.example.homework19.domain.models.MovieData
import com.example.homework19.domain.repository.MoviesRepository
import javax.inject.Inject

class GetAllMoviesUseCase @Inject constructor(private val repository: MoviesRepository) {

    suspend operator fun invoke(): List<MovieData> = repository.getMovies()
}