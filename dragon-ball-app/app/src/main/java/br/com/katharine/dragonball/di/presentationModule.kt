package br.com.katharine.dragonball.di

import br.com.katharine.dragonball.presentation.dragonball.detail.CharacterDetailViewModel
import br.com.katharine.dragonball.presentation.dragonball.search.CharacterSearchViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module


val presentationModule = module {
    viewModel {
        CharacterSearchViewModel()
    }

    viewModel {
        CharacterDetailViewModel(get())
    }
}
