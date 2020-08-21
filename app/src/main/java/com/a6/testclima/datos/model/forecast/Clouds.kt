package com.a6.testclima.datos.model.forecast


import com.google.gson.annotations.SerializedName

data class Clouds(
    @SerializedName("all")
    val forecastAll: Double
)