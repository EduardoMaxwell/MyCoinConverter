package br.com.dio.coinconverter.data.repository

import br.com.dio.coinconverter.core.exceptions.RemoteException
import br.com.dio.coinconverter.data.database.AppDatabase
import br.com.dio.coinconverter.data.model.ErrorResponse
import br.com.dio.coinconverter.data.model.ExchangeResponseValue
import br.com.dio.coinconverter.data.service.AwesomeService
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class CoinRepositoryImpl(
    appDatabase: AppDatabase,
    private val service: AwesomeService
) : CoinRepository {

    private val dao = appDatabase.exchangeDao()

    override suspend fun insertExchange(entity: ExchangeResponseValue) {
        dao.save(entity)
    }

    override fun listAll(): Flow<List<ExchangeResponseValue>> {
        return dao.findAll()
    }

    override suspend fun getExchangeValue(coins: String) = flow {

        try {
            val exchangeValue = service.exchangeValue(coins)
            val exchange = exchangeValue.values.first()
            emit(exchange)
        } catch (ex: HttpException) {
            val json = ex.response()?.errorBody()?.string()
            val errorResponse = Gson().fromJson(json, ErrorResponse::class.java)

            throw RemoteException(errorResponse.message)
        }
    }

}