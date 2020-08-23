package com.a6.testclima.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.a6.testclima.databinding.CeldaForecastBinding
import com.a6.testclima.datos.model.forecast.ForecastElement

class ForeCastAdapter : RecyclerView.Adapter<ForeCastAdapter.PostsViewHolder>() {

    var listForeCast: List<ForecastElement> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : ForeCastAdapter.PostsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val celdaListadoProductoBinding = CeldaForecastBinding
            .inflate(layoutInflater, parent, false)
        return PostsViewHolder(celdaListadoProductoBinding)
    }

    override fun getItemCount(): Int {
        return listForeCast.size
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        var algo = holder
        algo.cargarCelda(position)
    }

    inner class PostsViewHolder(val celdaListadoProductoBinding: CeldaForecastBinding):
        RecyclerView.ViewHolder(celdaListadoProductoBinding.root) {

        var binding:CeldaForecastBinding = celdaListadoProductoBinding

        fun cargarCelda(position: Int) {
            binding.celdaForeCastText1.text = listForeCast[position].forecastDtTxt
            binding.celdaForeCastText2.text = listForeCast[position].Weather[0].forecastDescription
        }
    }
}
