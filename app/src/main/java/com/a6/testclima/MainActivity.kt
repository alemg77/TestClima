package com.a6.testclima

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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
            val algo = apiService.getClimaActual("London,UK").await()
            Log.d(TAG, algo.toString())
            Log.d(TAG, "Que paso?")
        }

    }
}