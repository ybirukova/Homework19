package com.example.homework19.domain.repository

import com.example.homework19.domain.models.MovieData

interface FavoriteMovieRepository {

    suspend fun getFavoriteMovie(): MovieData?
}