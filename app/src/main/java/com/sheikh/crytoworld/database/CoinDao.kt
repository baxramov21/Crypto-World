package com.sheikh.crytoworld.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sheikh.crytoworld.pojos.coin_full_info.CoinPriceInfo

@Dao
interface CoinDao {
    @Query("SELECT * FROM crypto_database ORDER BY lastUpdate DESC")
    fun getListOfCoinPriceData(): LiveData<List<CoinPriceInfo>>

    @Query("SELECT * FROM crypto_database WHERE fromSymbol = :fSym")
    fun getSpecificCoinDetailInfo(fSym: String): LiveData<CoinPriceInfo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCoinPriceDataObject(coins: List<CoinPriceInfo>)
}