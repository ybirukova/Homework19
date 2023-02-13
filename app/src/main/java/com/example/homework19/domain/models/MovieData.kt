package com.example.homework19.domain.models

data class MovieData(
    val id: Int,
    val imageStr: String,
    val name: String,
    val isOscar: Boolean,
    val rating: Double,
    val about: String
)