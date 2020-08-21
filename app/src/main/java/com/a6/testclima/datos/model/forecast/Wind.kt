package com.a6.testclima.datos.model.forecast


import com.google.gson.annotations.SerializedName

data class Wind(
    @SerializedName("deg")
    val forecastDeg: Double,
    @SerializedName("speed")
    val forecastSpeed: Double
)