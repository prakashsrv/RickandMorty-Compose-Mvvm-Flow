package com.example.rickandmorty_compose_mvvm_flow.data.api

import com.example.rickandmorty_compose_mvvm_flow.data.model.characters.Characters
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface NetworkService {

    @GET("top-headlines")
    suspend fun getAllCharacters(): Response<Characters>

}