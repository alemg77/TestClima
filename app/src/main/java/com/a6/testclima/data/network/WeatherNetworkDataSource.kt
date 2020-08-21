package com.a6.testclima.data.network

import androidx.lifecycle.LiveData
import com.a6.testclima.data.network.response.CurrentWeatherResponse
import com.a6.testclima.data.network.response.FutureWeatherResponse


interface WeatherNetworkDataSource {
    val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>
    val downloadedFutureWeather: LiveData<FutureWeatherResponse>

    suspend fun fetchCurrentWeather(
        location: String,
        languageCode: String
    )
    suspend fun fetchFutureWeather(
        location: String,
        languageCode: String
    )
}