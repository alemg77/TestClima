package com.a6.testclima.datos.repository

import androidx.lifecycle.LiveData
import com.a6.testclima.datos.model.weather.WheatherDataPacket
import com.a6.testclima.datos.network.APIdata
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WheatherRepositoryImpl( private val apIdata: APIdata) : WheatherRepository {

    override suspend fun getCurrentWeather(city: String): LiveData<WheatherDataPacket> {
        TODO("Not yet implemented")
    }

    /*
    private var city:String? = null

    init {
        apIdata.dataWheather.observeForever { nerWheather ->


        }

    }

    override suspend fun getCurrentWeather(city: String): LiveData<WheatherDataPacket> {
        withContext(Dispatchers.IO) {
            return@withContext
        }
    }

    private fun persistFechtWheather (fetchedWeather: WheatherDataPacket) {
        GlobalScope.launch(Dispatchers.IO) {
            city?.let { apIdata.fetchWeather(it) }
        }
    }
     */
}