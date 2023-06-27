package com.sheikh.crytoworld.data.database.db_model.coin_full_info

import com.google.gson.JsonObject

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class CoinPriceInfoRawData (

    @SerializedName("RAW")
    @Expose
    val  coinListRawData: JsonObject
)