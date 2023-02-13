package com.example.homework19.di

import com.example.homework19.data.MoviesRepositoryImpl
import com.example.homework19.data.UserRepositoryImpl
import com.example.homework19.domain.repository.FavoriteMovieRepository
import com.example.homework19.domain.repository.MoviesRepository
import com.example.homework19.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule() {

    @Binds
    abstract fun getMovieRepository(impl: MoviesRepositoryImpl): MoviesRepository

    @Binds
    abstract fun getUserRepository(impl: UserRepositoryImpl): UserRepository

    @Binds
    abstract fun getFavoriteMovieRepository(impl: UserRepositoryImpl): FavoriteMovieRepository
}
