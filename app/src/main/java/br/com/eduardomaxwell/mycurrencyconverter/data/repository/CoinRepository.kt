package br.com.eduardomaxwell.mycurrencyconverter.data.repository

import br.com.eduardomaxwell.mycurrencyconverter.data.model.ExchangeResponseValue
import kotlinx.coroutines.flow.Flow

interface CoinRepository {

    fun listAll(): Flow<List<ExchangeResponseValue>>
    suspend fun getExchangeValue(coins: String): Flow<ExchangeResponseValue>

    suspend fun insertExchange(entity: ExchangeResponseValue)
}