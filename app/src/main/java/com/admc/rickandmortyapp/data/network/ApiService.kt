package com.admc.rickandmortyapp.data.network


import androidx.lifecycle.MutableLiveData
import com.admc.rickandmortyapp.data.model.Characters
import com.admc.rickandmortyapp.data.model.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class ApiService @Inject constructor( private val api: RickMortyApiClient) {
    suspend fun getCharacters(): List<Result> = suspendCancellableCoroutine { continuation ->
        val call: Call<Characters> = api.getAllCharacters()
        call.enqueue(object : Callback<Characters> {
            override fun onResponse(call: Call<Characters>, response: Response<Characters>) {
                if (response.isSuccessful) {
                    val characters = response.body()
                    val results = characters?.results ?: emptyList()
                    continuation.resume(results)
                } else {
                    continuation.resumeWithException(RuntimeException("Network request failed"))
                }
            }

            override fun onFailure(call: Call<Characters>, t: Throwable) {
                continuation.resumeWithException(t)
            }
        })

    }

}