package com.sheikh.crytoworld.pojos.top_coins_list

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import com.sheikh.crytoworld.pojos.top_coins_list.top_coin.Coin


data class ListOfTopCoins (
    @SerializedName("Data")
    @Expose
     val topCoinsList: List<Coin>?  = null
)