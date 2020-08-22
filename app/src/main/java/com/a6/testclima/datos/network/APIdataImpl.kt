package com.a6.testclima.datos.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.a6.testclima.datos.model.forecast.ForecastDataPacket
import com.a6.testclima.datos.model.weather.WheatherDataPacket
import com.a6.testclima.datos.network.APIdata
import com.a6.testclima.datos.network.RetrofitInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class APIdataImpl ( retrofitInterface: RetrofitInterface): APIdata {

    private val _dataWheather = MutableLiveData<WheatherDataPacket>()
    private val _dataForecast = MutableLiveData<ForecastDataPacket>()

    override val dataWheather: LiveData<WheatherDataPacket>
        get() = _dataWheather

    override val dataForecast: LiveData<ForecastDataPacket>
        get() = _dataForecast

    override suspend fun fetchWeather(city: String) {
        val apiService = RetrofitInterface()
        GlobalScope.launch(Dispatchers.Main) {
            val data = apiService.getClimaActual(city).await()
            _dataWheather.postValue(data)
        }
    }

    override suspend fun fetchForecast(city: String) {
        val apiService = RetrofitInterface()
        GlobalScope.launch(Dispatchers.Main) {
            val data = apiService.getForecast(city).await()
            _dataForecast.postValue(data)
        }
    }
}