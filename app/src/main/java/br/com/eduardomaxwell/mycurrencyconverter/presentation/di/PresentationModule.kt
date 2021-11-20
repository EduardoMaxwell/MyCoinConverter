package br.com.eduardomaxwell.mycurrencyconverter.presentation.di

import MainViewModel
import br.com.eduardomaxwell.mycurrencyconverter.presentation.HistoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object PresentationModule {

    fun load() {
        loadKoinModules(viewModelModule())
    }

    private fun viewModelModule(): Module {
        return module {
            viewModel { HistoryViewModel(get()) }
            viewModel { MainViewModel(get(), get()) }
        }
    }
}