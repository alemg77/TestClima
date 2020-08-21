package com.a6.testclima.data

import com.a6.testclima.model.RespuestaApiClima
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// Interface para traer los datos de la API con retrofit.


const val API_URL = "https://api.openweathermap.org/"
const val API_KEY_NAME = "APPID"
const val API_KEY = "aecba27d28f5e7e81724d328fbebbf98"


/*
 Ejemplo de uso:
 http://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=aecba27d28f5e7e81724d328fbebbf98
 */


interface ApiWebDatosClima {


    @GET("data/2.5/weather")
    fun getClimaActual(
        @Query("q") location: String
    ): Deferred<RespuestaApiClima> // La respuesta es asincronica.

    companion object {

        // Se encarga de atrapar y modificar todos los envios que entran y salen
        operator fun invoke(): ApiWebDatosClima {
            val requestInterceptor = Interceptor { chain ->

                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter(API_KEY_NAME, API_KEY)
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(API_URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiWebDatosClima::class.java)
        }
    }
}