package com.a6.testclima

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.a6.testclima.databinding.ActivityMainBinding
import com.a6.testclima.ui.FragmentForeCast
import com.a6.testclima.utils.ConnectivityStatus
import com.google.android.material.snackbar.Snackbar

const val ciudadBuenosAires: String = "Buenos Aires, AR"
const val ciudadSantaFe: String = "Santa Fe, AR"
const val ciudadCordoba: String = "Córdoba, AR"
const val ciudadParana: String = "Paraná, AR"
const val ciudadNeuquen: String = "Neuquén, AR"
const val ciudadMarDelPlata: String = "Mar del Plata, AR"

class MainActivity : AppCompatActivity() {

    private val TAG = javaClass.toString()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Log.d(TAG, "Inicio del programa")

        // Preparo el ToolBAR
        val toolbar = binding.MainActivityToolbar.cabezeratool
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(true)

        if (ConnectivityStatus(this)) {
            showFragmentForecast(ciudadMarDelPlata)
            supportActionBar?.title = "Mar del Plata"
        } else {
            supportActionBar?.title = "Sin Internet"
            Snackbar.make(binding.root, "No hay internet", Snackbar.LENGTH_INDEFINITE).show()
            Log.d(TAG, "NO TENEMOS INTERNET")
        }
    }

    private fun showFragmentForecast(city: String) {
        val bundle = Bundle()
        bundle.putSerializable(FragmentForeCast.KEY_CITY, city)
        val newFragment = FragmentForeCast()
        newFragment.arguments = bundle
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameMain, newFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.tool_bar_menu, menu);
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.toolbar_caba -> {
                showFragmentForecast(ciudadBuenosAires)
                supportActionBar?.title = "Buenos Aires"
            }

            R.id.toolbar_mar_del_plata -> {
                showFragmentForecast(ciudadMarDelPlata)
                supportActionBar?.title = "Mar del Plata"
            }

            R.id.toolbar_cordoba -> {
                showFragmentForecast(ciudadCordoba)
                supportActionBar?.title = "Cordoba"
            }

            R.id.toolbar_nuequen -> {
                showFragmentForecast(ciudadNeuquen)
                supportActionBar?.title = "Nuequen"
            }

            R.id.toolbar_parana -> {
                showFragmentForecast(ciudadParana)
                supportActionBar?.title = "Paraná"
            }

            R.id.toolbar_santa_fe -> {
                showFragmentForecast(ciudadSantaFe)
                supportActionBar?.title = "Santa Fe"
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val supportFragmentManager = this.supportFragmentManager
        if (supportFragmentManager.backStackEntryCount == 0) {
            finish()
        }
    }




}
