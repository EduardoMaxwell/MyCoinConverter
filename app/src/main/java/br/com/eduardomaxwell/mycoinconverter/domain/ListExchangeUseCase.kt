package br.com.eduardomaxwell.mycoinconverter.domain

import br.com.eduardomaxwell.mycoinconverter.core.UseCase
import br.com.eduardomaxwell.mycoinconverter.data.model.ExchangeResponseValue
import br.com.eduardomaxwell.mycoinconverter.data.repository.CoinRepository
import kotlinx.coroutines.flow.Flow

class ListExchangeUseCase(private val repository: CoinRepository) :
    UseCase.NoParam<List<ExchangeResponseValue>>() {
    override suspend fun execute(): Flow<List<ExchangeResponseValue>> {
        return repository.listAll()
    }
}