package com.a6.testclima.ui

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.a6.testclima.R
import com.a6.testclima.databinding.CeldaForecastBinding
import com.a6.testclima.datos.model.forecast.ForecastElement
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target

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

        private var binding:CeldaForecastBinding = celdaListadoProductoBinding

        fun cargarCelda(position: Int) {
            binding.celdaForeCastText1.text = listForeCast[position].forecastDtTxt
            binding.celdaForeCastText2.text = listForeCast[position].Weather[0].forecastDescription
            val forecastIcon = listForeCast[position].Weather[0].forecastIcon

            when (forecastIcon){
                "01d" -> Glide.with(binding.root).load(R.drawable.i01d).into(binding.celdaForecastImagen)
                "02d" -> Glide.with(binding.root).load(R.drawable.i02d).into(binding.celdaForecastImagen)
                "03d" -> Glide.with(binding.root).load(R.drawable.i03d).into(binding.celdaForecastImagen)
                "04d" -> Glide.with(binding.root).load(R.drawable.i04d).into(binding.celdaForecastImagen)
                "09d" -> Glide.with(binding.root).load(R.drawable.i09d).into(binding.celdaForecastImagen)
                "10d" -> Glide.with(binding.root).load(R.drawable.i10d).into(binding.celdaForecastImagen)
                "11d" -> Glide.with(binding.root).load(R.drawable.i10d).into(binding.celdaForecastImagen)
                "13d" -> Glide.with(binding.root).load(R.drawable.i13d).into(binding.celdaForecastImagen)
                "50d" -> Glide.with(binding.root).load(R.drawable.i50d).into(binding.celdaForecastImagen)
            }
        }
    }
}
