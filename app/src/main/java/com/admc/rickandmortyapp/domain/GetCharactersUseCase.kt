package com.admc.rickandmortyapp.domain

import com.admc.rickandmortyapp.data.RickMortyRepository
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(private val rickMortyRepository: RickMortyRepository) {
    suspend operator fun invoke() = rickMortyRepository.getCharacters()
}