package br.com.katharine.dragonball.data.model

import br.com.katharine.dragonball.domain.model.Character
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    val id: Int,
    val name: String,
    val image: String
)

fun CharacterResponse.toDomain(): Character {
    return Character(
        id = id,
        name = name,
        image = image
    )
}