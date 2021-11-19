package br.com.eduardomaxwell.mycoinconverter.domain

import br.com.eduardomaxwell.mycoinconverter.core.UseCase
import br.com.eduardomaxwell.mycoinconverter.data.model.ExchangeResponseValue
import br.com.eduardomaxwell.mycoinconverter.data.repository.CoinRepository
import kotlinx.coroutines.flow.Flow

class GetExchangeValueUseCase(
    private val repository: CoinRepository
) : UseCase<String, ExchangeResponseValue>() {

    override suspend fun execute(param: String): Flow<ExchangeResponseValue> {
        return repository.getExchangeValue(param)
    }
}