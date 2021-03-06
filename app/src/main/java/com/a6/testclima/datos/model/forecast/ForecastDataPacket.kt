package com.a6.testclima.datos.model.forecast


import com.google.gson.annotations.SerializedName

data class ForecastDataPacket(
    @SerializedName("city")
    val forecastCity: City,
    @SerializedName("cnt")
    val forecastCnt: Int,
    @SerializedName("cod")
    val forecastCod: String,
    @SerializedName("message")
    val forecastMessage: Int,
    @SerializedName("list")
    val listForeCast: List<ForecastElement>,
)