package com.a6.testclima.ui

import com.a6.testclima.datos.model.forecast.ForecastElement

interface RecyclerViewClickInterfase {
    fun onItemClick(forecastElement: ForecastElement)
    fun onLongItemClick(position: Int)
}
