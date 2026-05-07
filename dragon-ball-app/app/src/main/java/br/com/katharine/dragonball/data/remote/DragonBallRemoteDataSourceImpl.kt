package br.com.katharine.dragonball.data.remote

import br.com.katharine.dragonball.data.model.CharacterResponse

class DragonBallRemoteDataSourceImpl(
    private val api: DragonBallApi
) : DragonBallRemoteDataSource {

    override suspend fun getCharacterById(id: Int): CharacterResponse {
        return api.getCharacterById(id)
    }
}