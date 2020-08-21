package com.a6.testclima.model.forecast


import com.google.gson.annotations.SerializedName

data class Rain(
    @SerializedName("3h")
    val forecastH: Double
)