package com.a6.testclima.datos.model.forecast


import com.google.gson.annotations.SerializedName

data class ForecastMain(
    @SerializedName("feels_like")
    val forecastFeelsLike: Double,
    @SerializedName("grnd_level")
    val forecastGrndLevel: Double,
    @SerializedName("humidity")
    val forecastHumidity: Double,
    @SerializedName("pressure")
    val forecastPressure: Double,
    @SerializedName("sea_level")
    val forecastSeaLevel: Double,
    @SerializedName("temp")
    val forecastTemp: Double,
    @SerializedName("temp_kf")
    val forecastTempKf: Double,
    @SerializedName("temp_max")
    val forecastTempMax: Double,
    @SerializedName("temp_min")
    val forecastTempMin: Double
)