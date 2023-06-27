package com.sheikh.crytoworld.data.database.db_model.top_coins_list.coin_info

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class CoinInfo (

    @SerializedName("Name")
    @Expose
     val name: String? = null,

)