package com.sheikh.crytoworld.pojos

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




data class Cryptocurrency (

    @SerializedName("CoinInfo")
    @Expose
    private val coinInfo: CoinInfo? = null

)