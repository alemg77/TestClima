package com.a6.testclima.datos

import android.util.Log
import androidx.lifecycle.*
import com.a6.testclima.datos.model.weather.WheatherDataPacket
import com.a6.testclima.datos.network.APIdataImpl
import com.a6.testclima.datos.network.RetrofitInterface
import kotlinx.coroutines.launch


class WheatherViewModel(city: String) : ViewModel() {

    private val TAG = javaClass.toString()

    companion object {
        val retrofitInterface = RetrofitInterface()
        val apiData = APIdataImpl(retrofitInterface)
    }

    val datos: MutableLiveData<WheatherDataPacket> by lazy {
        MutableLiveData<WheatherDataPacket>()
    }

    init {
        Log.d(TAG, "Se inicio el View Model")
        viewModelScope.launch {
            apiData.fetchWeather(city)
        }
    }

    fun datos(): LiveData<WheatherDataPacket> {
        return apiData.dataWheather
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "Se termino el ViewModel ")
    }
}



