package com.a6.testclima

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.a6.testclima.databinding.ActivityMainBinding
import com.a6.testclima.databinding.ActivityMainBinding.*

import com.a6.testclima.ui.FragmentForeCast
import com.a6.testclima.utils.ConnectivityStatus
import com.google.android.material.snackbar.Snackbar


const val ciudadBuenosAires: String = "Buenos Aires, AR"
const val ciudadSantaFe: String = "Santa Fe, AR"
const val ciudadCordoba: String = "Córdoba, AR"
const val ciudadParana: String = "Paraná, AR"
const val ciudadNeuquen: String = "Neuquén, AR"
const val ciudadMarDelPlata: String = "Mar del Plata, AR"

/*
private lateinit var binding: ResultProfileBinding

override fun onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    binding = ResultProfileBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)
}

 */

class MainActivity : AppCompatActivity() {

    private val TAG = javaClass.toString()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Log.d(TAG, "Inicio del programa")

        if (ConnectivityStatus(this)) {
            val newFragment = FragmentForeCast()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frameMain, newFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        } else {
            Snackbar.make(binding.root, "No hay internet", Snackbar.LENGTH_INDEFINITE).show()
            Log.d(TAG, "NO TENEMOS INTERNET")
        }

    }
}

/*
val wheatherViewModelFactory = WheatherViewModelFactory(ciudadMarDelPlata )
val wheatherViewModel: WheatherViewModel by viewModels() { wheatherViewModelFactory}

wheatherViewModel.datos().observe(this, Observer {
    Log.d(TAG, it.toString())
    Log.d(TAG, "Que paso?")
})
 */