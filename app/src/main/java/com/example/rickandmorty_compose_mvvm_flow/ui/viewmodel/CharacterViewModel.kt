package com.example.rickandmorty_compose_mvvm_flow.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty_compose_mvvm_flow.data.api.NetworkChecker
import com.example.rickandmorty_compose_mvvm_flow.data.api.NetworkHelper
import com.example.rickandmorty_compose_mvvm_flow.data.model.characters.Characters
import com.example.rickandmorty_compose_mvvm_flow.data.repository.CharacterRepository
import com.example.rickandmorty_compose_mvvm_flow.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val characterRepository: CharacterRepository,
    private val networkChecker: NetworkChecker
) : ViewModel() {


    private val _characters = MutableLiveData<Resource<Characters>>()
    val characters: LiveData<Resource<Characters>>
        get() = _characters

    init {
        fetchCharacters()
    }

    private fun fetchCharacters() {
        viewModelScope.launch {
            _characters.postValue(Resource.loading(null))
            if (networkChecker.isNetworkConnected()) {
                characterRepository.getCharacters().let {
                    if (it.isSuccessful) {
                        _characters.postValue(Resource.success(it.body()))
                    } else _characters.postValue(Resource.error(it.errorBody().toString(), null))
                }
            } else _characters.postValue(Resource.error("No internet connection", null))
        }
    }
}