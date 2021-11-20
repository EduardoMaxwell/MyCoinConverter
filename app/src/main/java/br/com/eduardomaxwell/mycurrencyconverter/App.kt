package br.com.eduardomaxwell.mycurrencyconverter

import android.app.Application
import br.com.eduardomaxwell.mycurrencyconverter.data.di.DataModules
import br.com.eduardomaxwell.mycurrencyconverter.domain.di.DomainModule
import br.com.eduardomaxwell.mycurrencyconverter.presentation.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
        }

        DataModules.load()
        DomainModule.load()
        PresentationModule.load()
    }
}