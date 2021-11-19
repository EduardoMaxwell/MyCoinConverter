package br.com.eduardomaxwell.mycoinconverter

import android.app.Application
import br.com.eduardomaxwell.mycoinconverter.data.di.DataModules
import br.com.eduardomaxwell.mycoinconverter.domain.di.DomainModule
import br.com.eduardomaxwell.mycoinconverter.presentation.di.PresentationModule
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