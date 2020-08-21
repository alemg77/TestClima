package com.a6.testclima.datos.model.forecast


import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("coord")
    val forecastCoord: Coord,
    @SerializedName("country")
    val forecastCountry: String,
    @SerializedName("id")
    val forecastId: Int,
    @SerializedName("name")
    val forecastName: String,
    @SerializedName("population")
    val forecastPopulation: Int,
    @SerializedName("sunrise")
    val forecastSunrise: Double,
    @SerializedName("sunset")
    val forecastSunset: Double,
    @SerializedName("timezone")
    val forecastTimezone: Double
)