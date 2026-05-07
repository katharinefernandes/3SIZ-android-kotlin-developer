package br.com.katharine.dragonball.data.repository

import br.com.katharine.dragonball.data.model.toDomain
import br.com.katharine.dragonball.data.remote.DragonBallRemoteDataSource
import br.com.katharine.dragonball.domain.common.Resource
import br.com.katharine.dragonball.domain.model.Character
import br.com.katharine.dragonball.domain.repository.DragonBallRepository

class DragonBallRepositoryImpl(
    private val remoteDataSource: DragonBallRemoteDataSource
) : DragonBallRepository {

    override suspend fun getCharacterById(id: Int): Resource<Character> {
        return try {
            val response = remoteDataSource.getCharacterById(id)
            Resource.Success(response.toDomain())
        } catch (exception: Exception) {
            Resource.Error("Não foi possível buscar o personagem.")
        }
    }
}