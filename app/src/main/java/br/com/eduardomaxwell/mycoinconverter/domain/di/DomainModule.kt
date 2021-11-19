package br.com.eduardomaxwell.mycoinconverter.domain.di

import br.com.eduardomaxwell.mycoinconverter.domain.GetExchangeValueUseCase
import br.com.eduardomaxwell.mycoinconverter.domain.ListExchangeUseCase
import br.com.eduardomaxwell.mycoinconverter.domain.SaveExchangeUseCase
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object DomainModule {
    fun load() {
        loadKoinModules(useCaseModule())
    }

    private fun useCaseModule(): Module {
        return module {
            factory { GetExchangeValueUseCase(get()) }
            factory { SaveExchangeUseCase(get()) }
            factory { ListExchangeUseCase(get()) }
        }
    }
}