package br.com.eduardomaxwell.mycurrencyconverter.domain

import br.com.eduardomaxwell.mycurrencyconverter.core.UseCase
import br.com.eduardomaxwell.mycurrencyconverter.data.model.ExchangeResponseValue
import br.com.eduardomaxwell.mycurrencyconverter.data.repository.CoinRepository
import kotlinx.coroutines.flow.Flow

class ListExchangeUseCase(private val repository: CoinRepository) :
    UseCase.NoParam<List<ExchangeResponseValue>>() {
    override suspend fun execute(): Flow<List<ExchangeResponseValue>> {
        return repository.listAll()
    }
}