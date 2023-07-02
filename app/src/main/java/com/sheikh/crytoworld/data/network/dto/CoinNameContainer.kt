package com.sheikh.crytoworld.data.network.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinNameContainer(
    @SerializedName("CoinInfo")
    @Expose
    val coinName: CoinNameDto? = null
)