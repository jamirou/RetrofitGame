package com.jamirodev.retrofitgameapp.data

import com.jamirodev.retrofitgameapp.model.GamesModel
import com.jamirodev.retrofitgameapp.model.SingleGameModel
import com.jamirodev.retrofitgameapp.util.Constants.Companion.API_KEY
import com.jamirodev.retrofitgameapp.util.Constants.Companion.ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiGame {

    @GET(ENDPOINT + API_KEY)
    suspend fun getGame(): Response<GamesModel>

    @GET("$ENDPOINT/{id}$API_KEY")
    suspend fun getGameById(@Path(value = "id")id: Int): Response<SingleGameModel>

    @GET("$ENDPOINT/{name}$API_KEY")
    suspend fun getGameByName(@Path(value = "name")name: String): Response<SingleGameModel>
}