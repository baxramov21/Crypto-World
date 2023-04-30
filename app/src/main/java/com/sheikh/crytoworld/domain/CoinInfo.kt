package com.sheikh.crytoworld.domain

import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinInfo(

    @SerializedName("TYPE")
    @Expose
    val type: String,

    @PrimaryKey
    @SerializedName("FROMSYMBOL")
    @Expose
    val fromSymbol: String,

    @SerializedName("TOSYMBOL")
    @Expose
    val toSymbol: String,

    @SerializedName("PRICE")
    @Expose
    val price: Double,

    @SerializedName("LASTUPDATE")
    @Expose
    val lastUpdate: Long,

    @SerializedName("MARKET")
    @Expose
    val market: String,

    @SerializedName("VOLUMEDAYTO")
    @Expose
    val volumeDayTo: Double,

    @SerializedName("HIGHDAY")
    @Expose
    val highDay: Double,

    @SerializedName("LOWDAY")
    @Expose
    val lowDay: Double,


    @SerializedName("LASTMARKET")
    @Expose
    val lastMarket: String,

    @SerializedName("HIGHHOUR")
    @Expose
    val highHour: Double,

    @SerializedName("LOWHOUR")
    @Expose
    val lowHour: Double,

    @SerializedName("IMAGEURL")
    @Expose
    val imageUrl: String
)