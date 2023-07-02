package com.sheikh.crytoworld.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sheikh.crytoworld.data.database.db_model.CoinInfoDbModel

@Dao
interface CoinDao {
    @Query("SELECT * FROM crypto_database ORDER BY lastUpdate DESC")
    fun getCoinsList(): LiveData<List<CoinInfoDbModel>>

    @Query("SELECT * FROM crypto_database WHERE fromSymbol = :coinName")
    fun getCoin(coinName: String): LiveData<CoinInfoDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCoinsList(coins: List<CoinInfoDbModel>)
}