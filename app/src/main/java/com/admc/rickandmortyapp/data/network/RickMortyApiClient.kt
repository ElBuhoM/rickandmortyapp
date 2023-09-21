package com.admc.rickandmortyapp.data.network

import com.admc.rickandmortyapp.data.model.Characters
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface RickMortyApiClient {
    @GET("character")
     fun getAllCharacters():Call<Characters>
}