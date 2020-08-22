package com.a6.testclima.datos.repository

import androidx.lifecycle.LiveData
import com.a6.testclima.datos.model.weather.WheatherDataPacket

interface WheatherRepository {

    suspend fun getCurrentWeather(city:String): LiveData<WheatherDataPacket>


}