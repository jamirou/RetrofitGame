package com.jamirodev.retrofitgameapp.model

data class SingleGameModel(
    val name: String,
    val description_raw: String,
    val metacritic: Int,
    val website: String,
    val background_image: String
)
