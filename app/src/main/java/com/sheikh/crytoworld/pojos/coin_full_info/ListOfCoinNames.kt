package com.sheikh.crytoworld.pojos.coin_full_info

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import org.json.JSONObject


data class ListOfCoinNames (
    @SerializedName("RAW")
    @Expose
    private val coinTypeListData: JSONObject? = null
)