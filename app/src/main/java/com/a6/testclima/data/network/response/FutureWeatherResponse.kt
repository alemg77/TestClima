package com.a6.testclima.data.network.response

import com.a6.testclima.data.network.db.entity.WeatherLocation
import com.a6.testclima.data.network.response.ForecastDaysContainer
import com.google.gson.annotations.SerializedName

data class FutureWeatherResponse(
    @SerializedName("forecast")
    val futureWeatherEntries: ForecastDaysContainer,
    val location: WeatherLocation
)