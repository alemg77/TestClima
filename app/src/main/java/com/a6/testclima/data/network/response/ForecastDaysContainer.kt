package com.a6.testclima.data.network.response

import com.google.gson.annotations.SerializedName
import com.a6.testclima.data.network.db.entity.FutureWeatherEntry

data class ForecastDaysContainer(
    @SerializedName("forecastday")
    val entries: List<FutureWeatherEntry>
)