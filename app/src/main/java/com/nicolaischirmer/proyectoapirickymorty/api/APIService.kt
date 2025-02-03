package com.nicolaischirmer.proyectoapirickymorty.api

import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("character/")
    suspend fun listCharacters(@Query("page") page: Int): Result
}