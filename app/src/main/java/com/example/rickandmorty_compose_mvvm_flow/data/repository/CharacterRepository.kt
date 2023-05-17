package com.example.rickandmorty_compose_mvvm_flow.data.repository

import com.example.rickandmorty_compose_mvvm_flow.data.api.NetworkHelper
import javax.inject.Inject

class CharacterRepository @Inject constructor(private val networkHelper: NetworkHelper) {

    suspend fun getCharacters() = networkHelper.getAllCharacters()

}