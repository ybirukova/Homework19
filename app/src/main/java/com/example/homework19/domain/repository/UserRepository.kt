package com.example.homework19.domain.repository

import com.example.homework19.domain.models.UserData

interface UserRepository {

    suspend fun getUser(): UserData
}