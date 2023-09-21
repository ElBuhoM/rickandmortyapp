package com.admc.rickandmortyapp.data

import androidx.lifecycle.MutableLiveData
import com.admc.rickandmortyapp.data.model.Characters
import com.admc.rickandmortyapp.data.model.Result
import com.admc.rickandmortyapp.data.network.ApiService
import com.admc.rickandmortyapp.data.network.RickMortyApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class RickMortyRepository @Inject constructor(private val api: ApiService) {
    suspend fun getCharacters():List<Result> = api.getCharacters()
}