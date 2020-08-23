package com.a6.testclima.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.a6.testclima.databinding.FragmentForeCastBinding
import com.a6.testclima.datos.ForeCastViewModel
import com.a6.testclima.datos.ForeCastViewModelFactory

class FragmentForeCast : Fragment() {

    private val TAG = javaClass.toString()
    private var _binding: FragmentForeCastBinding? = null
    private val binding get() = _binding!!

    lateinit var city: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            //
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentForeCastBinding.inflate(inflater, container, false)
        val view = binding.root

        // Busco el nombre de la ciudad que me pasaron
        val bundle = arguments
        val city: String = bundle!!.getSerializable(KEY_CITY) as String

        binding.nombreCiudad.text = city

        val foreCastAdapter = ForeCastAdapter()

        binding.RecyclerViewForecast.layoutManager = LinearLayoutManager(context)
        binding.RecyclerViewForecast.adapter = foreCastAdapter

        val foreCastViewModelFactory = ForeCastViewModelFactory(city)
        val foreCastViewModel: ForeCastViewModel by viewModels() { foreCastViewModelFactory }

        foreCastViewModel.datos().observe(viewLifecycleOwner, Observer {
            foreCastAdapter.listForeCast = it.listForeCast
            foreCastAdapter.notifyDataSetChanged()
        })
        return view
    }

    companion object {
        val KEY_CITY = "NOMBRE DE LA CIUDAD"
    }

}