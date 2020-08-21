package com.a6.testclima.datos.model.forecast


import com.google.gson.annotations.SerializedName

data class Coord(
    @SerializedName("lat")
    val forecastLat: Double,
    @SerializedName("lon")
    val forecastLon: Double
)