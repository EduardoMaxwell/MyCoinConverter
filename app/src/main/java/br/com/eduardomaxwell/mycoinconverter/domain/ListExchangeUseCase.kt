package br.com.dio.coinconverter.domain

import br.com.dio.coinconverter.data.model.ExchangeResponseValue
import br.com.dio.coinconverter.data.repository.CoinRepository
import br.com.eduardomaxwell.mycoinconverter.core.UseCase
import kotlinx.coroutines.flow.Flow

class ListExchangeUseCase(private val repository: CoinRepository) :
    UseCase.NoParam<List<ExchangeResponseValue>>() {
    override suspend fun execute(): Flow<List<ExchangeResponseValue>> {
        return repository.listAll()
    }
}