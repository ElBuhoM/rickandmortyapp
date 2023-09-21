package com.admc.rickandmortyapp.data.model

import com.google.gson.annotations.SerializedName

data class Characters(
   @SerializedName("results") var results: List<Result>
)