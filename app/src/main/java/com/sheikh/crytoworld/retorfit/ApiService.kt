package com.sheikh.crytoworld.retorfit

import com.sheikh.crytoworld.pojos.ListOfCryptoCurrency
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("limit={limit}&tsym")
    fun getCoins(@Path("limit") limit: Int, @Query("tsym") convertingCurrency: String):
            MutableList<ListOfCryptoCurrency>
}