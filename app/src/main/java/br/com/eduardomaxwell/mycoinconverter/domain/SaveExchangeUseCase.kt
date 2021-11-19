package br.com.eduardomaxwell.mycoinconverter.domain

import ExchangeResponseValue
import br.com.eduardomaxwell.mycoinconverter.core.UseCase
import br.com.eduardomaxwell.mycoinconverter.data.repository.CoinRepository
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