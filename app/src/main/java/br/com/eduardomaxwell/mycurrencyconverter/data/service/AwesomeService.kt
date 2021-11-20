package br.com.eduardomaxwell.mycurrencyconverter.data.service

import br.com.eduardomaxwell.mycurrencyconverter.data.model.ExchangeResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface AwesomeService {

    @GET("/json/last/{coins}")
    suspend fun exchangeValue(@Path("coins") coins: String) :ExchangeResponse


}