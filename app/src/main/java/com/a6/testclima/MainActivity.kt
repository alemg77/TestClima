package com.a6.testclima

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
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

        //
        // Esto es solo un ensayo para verificar el funcionamiento
        // NUNCA JAMAS HARIA ESTO EN UNA VERSION FINAL
        //


        val apiService = ApiWebDatosClima()
        GlobalScope.launch(Dispatchers.Main) {
            val algo = apiService.getForecast(ciudadMarDelPlata).await()
            Log.d(TAG, algo.toString())
            Log.d(TAG, "Que paso?")
        }

    }
}