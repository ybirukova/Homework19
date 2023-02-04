package com.example.homework19.ui.all_movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework19.domain.models.MovieData
import com.example.homework19.domain.use_cases.GetAllMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getAllMoviesUseCase: GetAllMoviesUseCase
) : ViewModel() {

    private val _liveData = MutableLiveData<List<MovieData>>()
    val liveData: LiveData<List<MovieData>> get() = _liveData

    fun getAllMovies() {
        val movies = getAllMoviesUseCase.invoke()
        _liveData.value = movies
    }
}