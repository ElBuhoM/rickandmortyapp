package com.admc.rickandmortyapp.data.model

import com.google.gson.annotations.SerializedName

data class Result(
   @SerializedName("image") var image: String,
   @SerializedName("name") var name: String,
)