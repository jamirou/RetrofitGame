package com.jamirodev.retrofitgameapp.data

import com.jamirodev.retrofitgameapp.model.GamesModel
import com.jamirodev.retrofitgameapp.util.Constants.Companion.API_KEY
import com.jamirodev.retrofitgameapp.util.Constants.Companion.ENDPOINT
import retrofit2.Response
import retrofit2.http.GET

interface ApiGame {

    @GET(ENDPOINT + API_KEY)
    suspend fun getGame(): Response<GamesModel>
}