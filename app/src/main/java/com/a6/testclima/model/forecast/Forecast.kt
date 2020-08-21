package com.a6.testclima.model.forecast


import com.google.gson.annotations.SerializedName

data class Forecast(
    @SerializedName("city")
    val forecastCity: City,
    @SerializedName("cnt")
    val forecastCnt: Int,
    @SerializedName("cod")
    val forecastCod: String,
    @SerializedName("message")
    val forecastMessage: Int,
    @SerializedName("list")
    val forecastList: List<ForecastList>,
)