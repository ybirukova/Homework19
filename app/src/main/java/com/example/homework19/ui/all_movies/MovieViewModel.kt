package com.example.homework19.ui.all_movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework19.R
import com.example.homework19.domain.models.MovieData
import com.example.homework19.domain.use_cases.GetAllMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import java.net.SocketException
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getAllMoviesUseCase: GetAllMoviesUseCase
) : ViewModel() {

    private val _liveData = MutableLiveData<List<MovieData>>()
    val liveData: LiveData<List<MovieData>> get() = _liveData

    private val _errorLiveData = MutableLiveData<Int>()
    val errorLiveData: LiveData<Int> get() = _errorLiveData

    private val _loadingLiveData = MutableLiveData<Boolean>()
    val loadingLiveData: LiveData<Boolean> get() = _loadingLiveData

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _loadingLiveData.value = false
        when (throwable) {
            is SocketException, is UnknownHostException -> _errorLiveData.value =
                R.string.connection_error
            else -> _errorLiveData.value = R.string.unknown_error
        }
    }

    fun getAllMovies() {
        _loadingLiveData.value = true
        viewModelScope.launch(exceptionHandler) {
            val movies = getAllMoviesUseCase.invoke()
            _liveData.value = movies
            _loadingLiveData.value = false
        }
    }

    fun getLoadingStatus() {
        viewModelScope.launch {
        }
    }
}