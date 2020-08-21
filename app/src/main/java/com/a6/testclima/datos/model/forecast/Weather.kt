package com.a6.testclima.datos.model.forecast


import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("description")
    val forecastDescription: String,
    @SerializedName("icon")
    val forecastIcon: String,
    @SerializedName("main")
    val forecastMain: String,
    @SerializedName("id")
    val forecastId: Double,
)