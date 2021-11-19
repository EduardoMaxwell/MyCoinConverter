package br.com.eduardomaxwell.mycoinconverter.data.repository

import br.com.dio.coinconverter.data.model.ExchangeResponseValue
import kotlinx.coroutines.flow.Flow

interface CoinRepository {

    fun listAll(): Flow<List<ExchangeResponseValue>>
    suspend fun getExchangeValue(coins: String): Flow<ExchangeResponseValue>

    suspend fun insertExchange(entity: ExchangeResponseValue)
}