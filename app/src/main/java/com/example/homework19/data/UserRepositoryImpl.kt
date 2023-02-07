package com.example.homework19.data

import com.example.homework19.data.mappers.MovieMapper
import com.example.homework19.data.mappers.UserMapper
import com.example.homework19.domain.models.MovieData
import com.example.homework19.domain.models.UserData
import com.example.homework19.domain.repository.FavoriteMovieRepository
import com.example.homework19.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val service: Server,
    private val mapperUser: UserMapper,
    private val mapperMovie: MovieMapper
) : UserRepository, FavoriteMovieRepository {

    override suspend fun getUser(): UserData =
        withContext(Dispatchers.IO) { mapperUser(service.getUser()) }

    override suspend fun getFavoriteMovie(): MovieData? =
        withContext(Dispatchers.IO) {
            service.getMovieById(getUser().favoriteMovieId)?.let { mapperMovie(it) }
        }
}