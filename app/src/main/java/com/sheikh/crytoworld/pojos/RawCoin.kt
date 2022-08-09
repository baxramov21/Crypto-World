package com.sheikh.crytoworld.pojos

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




data class RawCoin (

    @SerializedName("USD")
    @Expose
    private val usd: ConvertingValueOfRawCoin? = null
)