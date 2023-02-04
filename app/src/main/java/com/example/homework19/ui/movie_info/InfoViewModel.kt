package com.example.homework19.ui.movie_info

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework19.domain.models.MovieData
import com.example.homework19.domain.use_cases.GetMovieByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InfoViewModel @Inject constructor(private val getMovieByIdUseCase: GetMovieByIdUseCase) :
    ViewModel() {

    private val _livedata = MutableLiveData<MovieData>()
    val liveData: LiveData<MovieData> get() = _livedata

    fun getMovieById(id: Int) {
        val movie = getMovieByIdUseCase.invoke(id)
        _livedata.value = movie
    }
}