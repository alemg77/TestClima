package com.a6.testclima.data.network.response

import com.google.gson.annotations.SerializedName
import com.a6.testclima.data.network.db.entity.CurrentWeatherEntry
import com.a6.testclima.data.network.db.entity.WeatherLocation

data class CurrentWeatherResponse(
    val location: WeatherLocation,
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry
)