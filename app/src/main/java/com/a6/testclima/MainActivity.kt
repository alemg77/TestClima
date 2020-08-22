package com.a6.testclima

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

import com.a6.testclima.datos.WheatherViewModel
import com.a6.testclima.datos.WheatherViewModelFactory
import com.a6.testclima.datos.network.APIdataImpl
import com.a6.testclima.datos.network.RetrofitInterface
import com.a6.testclima.utils.ConnectivityStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


const val ciudadBuenosAires: String = "Buenos Aires, AR"
const val ciudadSantaFe: String = "Santa Fe, AR"
const val ciudadCordoba: String = "Córdoba, AR"
const val ciudadParana: String = "Paraná, AR"
const val ciudadNeuquen: String = "Neuquén, AR"
const val ciudadMarDelPlata: String = "Mar del Plata, AR"


class MainActivity : AppCompatActivity() {

    private val TAG = javaClass.toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "Inicio del programa")

        if (ConnectivityStatus(this)) {
            Log.d(TAG, "Tenemos Internet")
        } else {
            Log.d(TAG, "NO TENEMOS INTERNET")
        }

        val wheatherViewModelFactory = WheatherViewModelFactory(ciudadMarDelPlata)
        val wheatherViewModel: WheatherViewModel by viewModels() { wheatherViewModelFactory}

        val testEnsayo = wheatherViewModel.testEnsayo()

        testEnsayo.observe(this, Observer {
            Log.d(TAG, it.toString())
            Log.d(TAG, "Que paso?")
        })


        /*
        val retrofitInterface = RetrofitInterface()
        var apiData = APIdataImpl(retrofitInterface)

        apiData.dataForecast.observe(this, Observer {
            Log.d(TAG, it.toString())
            Log.d(TAG, "Que paso?")
        })

        GlobalScope.launch(Dispatchers.Main) {
            apiData.fetchForecast(ciudadMarDelPlata)
        }

         */
    }
}