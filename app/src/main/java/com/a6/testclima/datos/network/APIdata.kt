package com.a6.testclima.datos.network

import androidx.lifecycle.LiveData
import com.a6.testclima.datos.model.forecast.ForecastDataPacket
import com.a6.testclima.datos.model.weather.WheatherDataPacket

interface APIdata {

    val dataWheather: LiveData<WheatherDataPacket>
    val dataForecast: LiveData<ForecastDataPacket>

    suspend fun fetchWeather (city: String)
    suspend fun fetchForecast (city: String)
}