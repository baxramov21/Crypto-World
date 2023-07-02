package com.sheikh.crytoworld.domain.repository

import androidx.lifecycle.LiveData
import com.sheikh.crytoworld.domain.entity.CoinInfoEntity

interface Repository {
    fun getCoinsList(): LiveData<List<CoinInfoEntity>>

    fun getCoinInfo(coinName: String): LiveData<CoinInfoEntity>

    suspend fun loadData(apiKey: String, topCoinsLimit: Int, convertTo: String)
}