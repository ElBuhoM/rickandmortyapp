package com.admc.rickandmortyapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.admc.rickandmortyapp.data.model.Characters
import com.admc.rickandmortyapp.data.model.Result
import com.admc.rickandmortyapp.data.network.RickMortyApiClient
import com.admc.rickandmortyapp.domain.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RickMortyViewModel @Inject constructor(private val getCharactersUseCase: GetCharactersUseCase) : ViewModel() {
    val charactersList = MutableLiveData<List<Result>>()
    val errorMessage: MutableLiveData<String> = MutableLiveData()

    fun getCharacters(){
        viewModelScope.launch {
            try {
                val listCharacter = getCharactersUseCase()
                charactersList.postValue(listCharacter)
            } catch (e:Exception){
                errorMessage.postValue("Error al cargar los personajes: ${e.message}")
                throw Exception(e)
            }

        }
    }


}