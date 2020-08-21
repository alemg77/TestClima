package com.a6.testclima.datos

import com.a6.testclima.datos.model.forecast.ForecastDataPacket
import com.a6.testclima.datos.model.weather.WheatherDataPacket
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// Interface para traer los datos de la API con retrofit.


const val BASE_URL: String = "http://api.openweathermap.org"
const val API_KEY_NAME: String = "APPID"
const val API_KEY: String = "aecba27d28f5e7e81724d328fbebbf98"

interface RetrofitInterface {

    @GET("data/2.5/weather")
    fun getClimaActual(
        @Query("q") location: String,
        @Query( "lang") languageCode: String = "sp",
        @Query( "units") units: String = "metric"
    ): Deferred<WheatherDataPacket> // La respuesta es asincronica.

    @GET("data/2.5/forecast")
    fun getForecast(
        @Query("q") location: String
    ): Deferred<ForecastDataPacket>

    companion object {
        operator fun invoke( ): RetrofitInterface {
            // Creo un interceptor para agregar la KEY
            val requestInterceptor = Interceptor { chain ->
                val url = chain.request()
                    .url
                    .newBuilder()
                    .addQueryParameter(API_KEY_NAME, API_KEY)
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)
            }

            // Preparo el cliente OkHttp
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                // TODO: Agregar un Interceptor que verifique el estado de la coneccion
                .build()

            // Preparo retrofit.
            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitInterface::class.java)
        }
    }

}
