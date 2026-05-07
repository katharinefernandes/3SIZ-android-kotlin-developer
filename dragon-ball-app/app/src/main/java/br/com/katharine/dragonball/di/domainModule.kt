package br.com.katharine.dragonball.di

import br.com.katharine.dragonball.domain.usecase.GetCharacterByIdUseCase
import org.koin.dsl.module

val domainModule = module {

    factory {
        GetCharacterByIdUseCase(repository = get())
    }
}