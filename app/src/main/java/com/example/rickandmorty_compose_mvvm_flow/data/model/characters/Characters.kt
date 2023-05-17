package com.example.rickandmorty_compose_mvvm_flow.data.model.characters

import com.google.gson.annotations.SerializedName


data class Characters (

  @SerializedName("info"    ) var info    : Info?              = Info(),
  @SerializedName("results" ) var results : ArrayList<Results> = arrayListOf()

)