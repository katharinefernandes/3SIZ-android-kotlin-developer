package br.com.katharine.dragonball

import android.app.Application
import br.com.katharine.dragonball.di.dataModule
import br.com.katharine.dragonball.di.domainModule
import br.com.katharine.dragonball.di.networkModule
import br.com.katharine.dragonball.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DragonBallApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@DragonBallApplication)

            modules(
                networkModule,
                dataModule,
                domainModule,
                presentationModule
            )
        }
    }
}