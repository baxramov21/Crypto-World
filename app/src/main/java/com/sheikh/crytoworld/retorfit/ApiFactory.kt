package com.sheikh.crytoworld.retorfit

import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit as Retrofit

object ApiFactory {
    private const val BASE_URL: String = "https://min-api.cryptocompare.com/data/top/totalvolfull?"

    private var retrofitObject: Retrofit? = null

    fun getRetrofitClient(): Retrofit {
        if (retrofitObject == null) {
            retrofitObject = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build()
        }
        return retrofitObject!!
    }

    fun getApiService(): ApiService {
        var result: ApiService? = null
        retrofitObject?.let {
            result = it.create(ApiService::class.java)
        }
        return result!!
    }
}