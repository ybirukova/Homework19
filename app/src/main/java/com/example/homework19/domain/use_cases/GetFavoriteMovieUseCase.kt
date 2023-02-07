package com.example.homework19.domain.use_cases

import com.example.homework19.domain.models.MovieData
import com.example.homework19.domain.repository.FavoriteMovieRepository
import javax.inject.Inject

class GetFavoriteMovieUseCase @Inject constructor(private val repository: FavoriteMovieRepository) {

    suspend operator fun invoke(): MovieData? = repository.getFavoriteMovie()
}