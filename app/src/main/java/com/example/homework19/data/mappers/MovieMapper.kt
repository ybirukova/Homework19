package com.example.homework19.data.mappers

import com.example.homework19.data.models.MovieResponse
import com.example.homework19.domain.models.MovieData
import javax.inject.Inject

class MovieMapper @Inject constructor() {

    operator fun invoke(response: MovieResponse) = with(response) {
        MovieData(
            imageStr = imageStr.orEmpty(),
            name = name.orEmpty(),
            isOscar = isOscar ?: false,
            rating = rating ?: 0.0,
            about = about ?: ""
        )
    }
}