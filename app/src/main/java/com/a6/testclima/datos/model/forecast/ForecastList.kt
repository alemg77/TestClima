package com.a6.testclima.datos.model.forecast

import com.google.gson.annotations.SerializedName

data class ForecastList (
    @SerializedName("clouds")
    val forecastClouds: Clouds,
    @SerializedName("dt")
    val forecastDt: Int,
    @SerializedName("dt_txt")
    val forecastDtTxt: String,
    @SerializedName("sys")
    val forecastSys: Sys,
    @SerializedName("wind")
    val forecastWind: Wind,
    @SerializedName("visibility")
    val forecastVisibility: Int,
    @SerializedName("weather")
    val forecastWeather: List<Weather>,
)