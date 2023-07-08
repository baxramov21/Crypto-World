package com.sheikh.crytoworld.data.network.dto

import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class CoinInfoJsonContainer(
    @SerializedName("RAW")
    @Expose
    val coinNameJsonObject: JsonObject? = null
)