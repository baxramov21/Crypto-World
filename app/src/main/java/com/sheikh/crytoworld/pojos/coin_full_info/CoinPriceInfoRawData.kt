package com.sheikh.crytoworld.pojos.coin_full_info

import com.google.gson.JsonObject
import org.json.JSONObject

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class CoinPriceInfoRawData (

    @SerializedName("RAW")
    @Expose
    val  coinListRawData: JsonObject
)