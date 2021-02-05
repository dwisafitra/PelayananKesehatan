package com.tempatpelayanankesehatan.tpk.network

import com.androidnetworking.interceptors.HttpLoggingInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Azhar Rivaldi on 22-12-2019.
 */

class ApiConfig {

    companion object {
        const val BASE_URL = "https://maps.googleapis.com/maps/api/place/"
        const val BASE_URL_USER = "http://192.168.100.72:8087/api-android/public/api/"
        const val API_KEY = "AIzaSyC8EMTLbVT7VLExa3SbMEPrJkHzk2tGrMw"

        private val retrofit by lazy {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .build()

            Retrofit.Builder()
                    .baseUrl(BASE_URL_USER)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }

        val apiUser by lazy {
            retrofit.create(ApiUser::class.java)
        }
    }

    private fun retrofit(): Retrofit {

        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    }

    fun instance(): ApiInterface {
        return retrofit().create(ApiInterface::class.java)
    }

}
