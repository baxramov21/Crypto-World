package com.sheikh.crytoworld.pojos.top_coins_list.top_coin

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import com.sheikh.crytoworld.pojos.top_coins_list.coin_info.CoinInfo


data class Coin (

    @SerializedName("CoinInfo")
    @Expose
    val coinInfo: CoinInfo?

)