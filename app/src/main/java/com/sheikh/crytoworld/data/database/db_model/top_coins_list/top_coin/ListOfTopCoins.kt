package com.sheikh.crytoworld.data.database.db_model.top_coins_list.top_coin

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class ListOfTopCoins (
    @SerializedName("Data")
    @Expose
     val topCoinsList: List<Coin>?  = null
)