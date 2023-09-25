package com.jamirodev.retrofitgameapp.repository

import com.jamirodev.retrofitgameapp.data.ApiGame
import com.jamirodev.retrofitgameapp.model.GameList
import javax.inject.Inject

class GamesRepository @Inject constructor(private val apiGame: ApiGame) {

    suspend fun getGames(): List<GameList>? {
        val response = apiGame.getGame()
        if (response.isSuccessful) {
            return response.body()?.results
        }
        return null
    }

}