package com.jamirodev.retrofitgameapp.util

class Constants {
    companion object {
        const val BASE_URL = "https://api.rawg.io/api/"
        const val ENDPOINT = "games"
        const val API_KEY = "?key=376ac9acebc34c6298778cdb7531cfc4"
        const val COLOR_1 = 0xFF2EB086.toInt() //mint
        const val COLOR_2 = 0xFFB8405E.toInt() //red retro
        const val COLOR_3 = 0xFF313552.toInt() //dark retro
        const val COLOR_4 = 0xFFEEE6CE.toInt() //white retro

    }
}

// https://api.rawg.io/api/games?key=376ac9acebc34c6298778cdb7531cfc4
// https://api.rawg.io/api/games/id?key=376ac9acebc34c6298778cdb7531cfc4