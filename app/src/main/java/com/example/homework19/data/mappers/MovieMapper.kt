package com.example.homework19.data.mappers

import android.graphics.Movie
import com.example.homework19.data.models.MovieResponse
import com.example.homework19.domain.models.MovieData

class MovieMapper {

    operator fun invoke(response: MovieResponse) = with(response) {
        MovieData(
            imageStr = imageStr ?: "",
            name = name ?: "",
            isOscar = isOscar ?: false,
            rating = rating ?: 0.0,
            about = about ?: ""
        )
    }
}