package com.example.rickandmorty_compose_mvvm_flow.data.api

import com.example.rickandmorty_compose_mvvm_flow.data.model.characters.Characters
import retrofit2.Response

interface NetworkHelper {

    suspend fun getAllCharacters(): Response<Characters>
}