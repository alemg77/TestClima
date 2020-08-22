package com.a6.testclima.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.a6.testclima.ciudadMarDelPlata
import com.a6.testclima.databinding.FragmentForeCastBinding
import com.a6.testclima.datos.ForeCastViewModel
import com.a6.testclima.datos.ForeCastViewModelFactory

class FragmentForeCast : Fragment() {

    private val TAG = javaClass.toString()
    private var _binding: FragmentForeCastBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            //
        }
    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentForeCastBinding.inflate(inflater, container, false)
        val view = binding.root

        val foreCastViewModelFactory = ForeCastViewModelFactory(ciudadMarDelPlata)
        val foreCastViewModel: ForeCastViewModel by viewModels() { foreCastViewModelFactory}

        foreCastViewModel.datos().observe(viewLifecycleOwner, Observer {
            Log.d(TAG, it.toString())
            Log.d(TAG, "Que paso?")
        })
        return view
    }


    companion object {

    }

}