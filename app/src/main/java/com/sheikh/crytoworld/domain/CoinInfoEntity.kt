package com.sheikh.crytoworld.domain

data class CoinInfoEntity(
    val type: String,
    val fromSymbol: String,
    val toSymbol: String,
    val price: Double,
    val lastUpdate: Long,
    val highDay: Double,
    val lowDay: Double,
    val lastMarket: String,
    val highHour: Double,
    val lowHour: Double,
    val imageUrl: String
)