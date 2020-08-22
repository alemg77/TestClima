package com.a6.testclima.datos

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.a6.testclima.MainActivity

class WheatherViewModelFactory(private val city: String) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WheatherViewModel::class.java)) {
            return WheatherViewModel(city) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }


}

