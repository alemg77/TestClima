package com.a6.testclima.model.forecast


import com.google.gson.annotations.SerializedName

data class Coord(
    @SerializedName("lat")
    val forecastLat: Double,
    @SerializedName("lon")
    val forecastLon: Double
)