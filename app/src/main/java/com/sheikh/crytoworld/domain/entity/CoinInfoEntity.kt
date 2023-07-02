package com.sheikh.crytoworld.domain.entity

data class CoinInfoEntity(
    val type: String,
    val market: String,
    val fromSymbol: String,
    val toSymbol: String,
    val price: Double,
    val lastUpdate: Long,
    val lastTradeId: String,
    val highDay: Double,
    val lowDay: Double,
    val lastMarket: String,
    val highHour: Double,
    val lowHour: Double,
    val imageUrl: String
)