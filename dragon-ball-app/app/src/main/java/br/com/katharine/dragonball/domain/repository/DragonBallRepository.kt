package br.com.katharine.dragonball.domain.repository

import br.com.katharine.dragonball.domain.common.Resource
import br.com.katharine.dragonball.domain.model.Character

interface DragonBallRepository {
    suspend fun getCharacterById(id: Int): Resource<Character>
}