package com.example.example

import com.google.gson.annotations.SerializedName


data class Characters (

  @SerializedName("info"    ) var info    : Info?              = Info(),
  @SerializedName("results" ) var results : ArrayList<Results> = arrayListOf()

)