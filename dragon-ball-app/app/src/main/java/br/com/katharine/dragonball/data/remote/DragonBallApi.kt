package br.com.katharine.dragonball.data.remote

import br.com.katharine.dragonball.data.model.CharacterResponse
import br.com.katharine.dragonball.domain.model.Character
import retrofit2.http.GET
import retrofit2.http.Path

interface DragonBallApi {

    @GET("characters/{id}")
    suspend fun getCharacterById(
        @Path("id") id: Int
    ): CharacterResponse

}