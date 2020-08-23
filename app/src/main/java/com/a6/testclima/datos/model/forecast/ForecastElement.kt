package com.a6.testclima.datos.model.forecast

import com.google.gson.annotations.SerializedName

data class ForecastElement (
    @SerializedName("clouds")
    val Clouds: Clouds,
    @SerializedName("dt")
    val dt: Int,
    @SerializedName("dt_txt")
    val forecastDtTxt: String,
    @SerializedName("sys")
    val forecastSys: Sys,
    @SerializedName("wind")
    val forecastWind: Wind,
    @SerializedName("visibility")
    val forecastVisibility: Int,
    @SerializedName("weather")
    val Weather: List<Weather>,
)
