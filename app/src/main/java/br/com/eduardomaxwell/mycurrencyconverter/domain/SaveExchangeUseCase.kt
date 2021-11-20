package br.com.eduardomaxwell.mycurrencyconverter.domain

import br.com.eduardomaxwell.mycurrencyconverter.core.UseCase
import br.com.eduardomaxwell.mycurrencyconverter.data.model.ExchangeResponseValue
import br.com.eduardomaxwell.mycurrencyconverter.data.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SaveExchangeUseCase(private val repository: CoinRepository): UseCase.NoSource<ExchangeResponseValue>() {

    override suspend fun execute(param: ExchangeResponseValue): Flow<Unit> {
       return flow {
           repository.insertExchange(param)
           emit(Unit)
       }
    }
}