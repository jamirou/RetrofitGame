package com.jamirodev.retrofitgameapp.state

data class GameState(
    val name: String = "",
    val description_raw: String = "",
    val metacritic: Int = 0,
    val website: String = "",
    val background_image: String = ""
)
