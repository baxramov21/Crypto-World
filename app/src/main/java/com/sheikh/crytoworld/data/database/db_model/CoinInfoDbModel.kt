package com.sheikh.crytoworld.data.database.db_model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "crypto_database")
data class CoinInfoDbModel(
    val type: String?,
    val market: String?,
    @PrimaryKey
    val fromSymbol: String,
    val toSymbol: String?,
    val price: Double?,
    val lastUpdate: Long?,
    val lastTradeId: String?,
    val highDay: Double?,
    val lowDay: Double?,
    val lastMarket: String?,
    val highHour: Double?,
    val lowHour: Double?,
    val imageUrl: String
)