package com.jamirodev.retrofitgameapp.repository

import com.jamirodev.retrofitgameapp.data.ApiGame
import com.jamirodev.retrofitgameapp.model.GameList
import com.jamirodev.retrofitgameapp.model.SingleGameModel
import javax.inject.Inject

class GamesRepository @Inject constructor(private val apiGame: ApiGame) {

    suspend fun getGames(): List<GameList>? {
        val response = apiGame.getGame()
        if (response.isSuccessful) {
            return response.body()?.results
        }
        return null
    }

    suspend fun getGameById(id: Int): SingleGameModel? {
        val response = apiGame.getGameById(id)
        if (response.isSuccessful) {
            return response.body()
        }
        return null
    }
}