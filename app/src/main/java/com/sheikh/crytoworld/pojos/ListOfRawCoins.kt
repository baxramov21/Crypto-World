package com.sheikh.crytoworld.pojos

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




data class ListOfRawCoins (

    @SerializedName("BTC")
    @Expose
    private val rawCoinJsonObject: RawCoin? = null

)