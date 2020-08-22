package com.a6.testclima.datos

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.a6.testclima.datos.model.weather.WheatherDataPacket
import com.a6.testclima.datos.network.APIdataImpl
import com.a6.testclima.datos.network.RetrofitInterface
import kotlinx.coroutines.launch


class WheatherViewModel():ViewModel(){

    private val TAG = javaClass.toString()

    private var city:String = "Buenos Aires, AR"

    val ensayo: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val datos: MutableLiveData<WheatherDataPacket> by lazy {
        MutableLiveData<WheatherDataPacket>()
    }

    fun testEnsayo() {
        ensayo.postValue("Hola")
    }

    init {
        Log.d(TAG, "Se inicio el View Model")
        val retrofitInterface = RetrofitInterface()
        var apiData = APIdataImpl(retrofitInterface)

        /*
        apiData.dataWheather.observe(LifecycleOwner, Observer {

        } })

         */

        viewModelScope.launch {
            apiData.fetchForecast(city)
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "Se termino el ViewModel ")
    }
}



