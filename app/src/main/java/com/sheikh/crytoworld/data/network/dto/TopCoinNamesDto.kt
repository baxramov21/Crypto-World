package com.sheikh.crytoworld.data.network.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class TopCoinNamesDto(
    @SerializedName("Data")
    @Expose
    val topCoinNames: List<CoinNameContainerDto>? = null
)