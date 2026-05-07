package br.com.katharine.dragonball.domain.usecase

import br.com.katharine.dragonball.domain.common.Resource
import br.com.katharine.dragonball.domain.model.Character
import br.com.katharine.dragonball.domain.repository.DragonBallRepository

class GetCharacterByIdUseCase(
    private val repository: DragonBallRepository
) {
    suspend operator fun invoke(id: Int): Resource<Character> {
        if (id <= 0) {
            return Resource.Error("Informe um número maior que zero.")
        }

        if (id > 78) {
            return Resource.Error("Informe um número válido até 78.")
        }

        return repository.getCharacterById(id)
    }
}