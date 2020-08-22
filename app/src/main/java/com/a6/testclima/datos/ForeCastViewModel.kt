package com.a6.testclima.datos

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.a6.testclima.datos.model.forecast.ForecastDataPacket
import com.a6.testclima.datos.network.APIdataImpl
import com.a6.testclima.datos.network.RetrofitInterface
import kotlinx.coroutines.launch

class ForeCastViewModel(city: String) : ViewModel() {

    private val TAG = javaClass.toString()

    companion object {
        val retrofitInterface = RetrofitInterface()
        val apiData = APIdataImpl(retrofitInterface)
    }

    val datos: MutableLiveData<ForeCastViewModel> by lazy {
        MutableLiveData<ForeCastViewModel>()
    }

    init {
        Log.d(TAG, "Se inicio el View Model")
        viewModelScope.launch {
            apiData.fetchForecast(city)
        }
    }

    fun datos(): LiveData<ForecastDataPacket> {
        return apiData.dataForecast
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "Se termino el ViewModel ForeCastViewModel")
    }
}
