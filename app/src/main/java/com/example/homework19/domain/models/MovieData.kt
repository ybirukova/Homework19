package com.example.homework19.domain.models

data class MovieData(
    val imageStr: String,
    val name: String,
    val isOscar: Boolean,
    val rating: Double,
    val about: String
)