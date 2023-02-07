package com.example.homework19.data.mappers

import com.example.homework19.data.models.UserResponse
import com.example.homework19.domain.models.UserData
import javax.inject.Inject

class UserMapper @Inject constructor() {

    operator fun invoke(response: UserResponse): UserData = with(response) {
        UserData(
            userId = userId ?: -1,
            favoriteMovieId = favoriteMovieId ?: -1
        )
    }
}