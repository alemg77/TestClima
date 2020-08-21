package com.a6.testclima.model.forecast


import com.google.gson.annotations.SerializedName

data class Clouds(
    @SerializedName("all")
    val forecastAll: Double
)