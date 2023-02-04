package com.example.homework19.di

import com.example.homework19.data.MoviesRepositoryImpl
import com.example.homework19.domain.repository.MoviesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule() {

    @Binds
    abstract fun getMovieRepository(impl: MoviesRepositoryImpl): MoviesRepository
}
