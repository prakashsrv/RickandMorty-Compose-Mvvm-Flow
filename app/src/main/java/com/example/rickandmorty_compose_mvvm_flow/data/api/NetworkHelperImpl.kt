package com.example.rickandmorty_compose_mvvm_flow.data.api

import com.example.rickandmorty_compose_mvvm_flow.data.model.characters.Characters
import retrofit2.Response
import javax.inject.Inject

class NetworkHelperImpl @Inject constructor(private val networkService: NetworkService): NetworkHelper {
    override suspend fun getAllCharacters(): Response<Characters> = networkService.getAllCharacters()
}