package com.sheikh.crytoworld.domain

import androidx.lifecycle.LiveData
import com.sheikh.crytoworld.domain.entity.CoinInfoEntity

interface Repository {
    fun getLatestCoinsList(): LiveData<List<CoinInfoEntity>>

    fun getLatestCoinInfo(coinName: String): LiveData<CoinInfoEntity>

    fun getSavedCoinsList():  LiveData<List<CoinInfoEntity>>

    fun getSavedCoinInfo(coinName: String): CoinInfoEntity

    fun setCoinsList(coinsList: List<CoinInfoEntity>)
}