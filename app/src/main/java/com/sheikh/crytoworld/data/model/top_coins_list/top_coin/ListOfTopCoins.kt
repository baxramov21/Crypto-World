package com.sheikh.crytoworld.data.model.top_coins_list.top_coin

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import com.sheikh.crytoworld.data.model.top_coins_list.top_coin.Coin


data class ListOfTopCoins (
    @SerializedName("Data")
    @Expose
     val topCoinsList: List<Coin>?  = null
)