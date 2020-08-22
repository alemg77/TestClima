package com.a6.testclima.datos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class WheatherViewModelFactory ( private val city:String) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WheatherViewModel::class.java)) {
            return WheatherViewModel(city) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }


}

