package com.sheikh.crytoworld.domain.repository

import androidx.lifecycle.LiveData
import com.sheikh.crytoworld.domain.entity.CoinInfoEntity

interface Repository {
    fun getCoinsList(): LiveData<List<CoinInfoEntity>>

    suspend fun getCoinInfo(coinName: String): CoinInfoEntity

    fun loadData(topCoinsLimit: Int, convertTo: String)
}