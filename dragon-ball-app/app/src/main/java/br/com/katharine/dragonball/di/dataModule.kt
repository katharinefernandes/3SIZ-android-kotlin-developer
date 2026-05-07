package br.com.katharine.dragonball.di

import br.com.katharine.dragonball.data.remote.DragonBallRemoteDataSource
import br.com.katharine.dragonball.data.remote.DragonBallRemoteDataSourceImpl
import br.com.katharine.dragonball.data.repository.DragonBallRepositoryImpl
import br.com.katharine.dragonball.domain.repository.DragonBallRepository
import org.koin.dsl.module

val dataModule = module {

    single<DragonBallRemoteDataSource> {
        DragonBallRemoteDataSourceImpl(api = get())
    }

    single<DragonBallRepository> {
        DragonBallRepositoryImpl(remoteDataSource = get())
    }
}