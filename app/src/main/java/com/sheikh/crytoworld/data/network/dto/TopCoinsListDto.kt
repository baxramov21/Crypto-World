package com.sheikh.crytoworld.data.network.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class TopCoinsListDto(
    @SerializedName("Data")
    @Expose
    val data: List<CoinNameContainer>? = null
)