package com.example.homework19.ui.unpopular_movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework19.domain.models.MovieData
import com.example.homework19.domain.use_cases.GetUnpopularMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UnpopularMovieViewModel @Inject constructor(
    private val getUnpopularMoviesUseCase: GetUnpopularMoviesUseCase
) : ViewModel() {

    private val _liveData = MutableLiveData<List<MovieData>>()
    val liveData: LiveData<List<MovieData>> get() = _liveData

    fun getUnpopularMovies() {
        viewModelScope.launch {
            val movies = getUnpopularMoviesUseCase.invoke()
            _liveData.value = movies
        }

    }
}