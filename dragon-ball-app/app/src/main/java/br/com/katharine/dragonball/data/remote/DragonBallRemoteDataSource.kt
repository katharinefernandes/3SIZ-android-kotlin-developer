package br.com.katharine.dragonball.data.remote

import br.com.katharine.dragonball.data.model.CharacterResponse

interface DragonBallRemoteDataSource {
    suspend fun getCharacterById(id: Int): CharacterResponse
}