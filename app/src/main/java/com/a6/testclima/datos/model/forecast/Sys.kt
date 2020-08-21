package com.a6.testclima.datos.model.forecast


import com.google.gson.annotations.SerializedName

data class Sys(
    @SerializedName("pod")
    val forecastPod: String
)