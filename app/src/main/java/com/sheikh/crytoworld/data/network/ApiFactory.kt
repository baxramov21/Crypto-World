package com.sheikh.crytoworld.data.network

import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit as Retrofit

object ApiFactory {

    private const val BASE_URL: String = "https://min-api.cryptocompare.com/data/"
    const val BASE_IMAGE_URL: String = "https://cryptocompare.com"

    private val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)

}