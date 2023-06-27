package com.sheikh.crytoworld.domain

import androidx.lifecycle.LiveData

interface Repository {
    fun getLatestCoinsList(): LiveData<List<CoinInfoEntity>>

    fun getLatestCoinInfo(coinName: String): LiveData<CoinInfoEntity>

    fun getSavedCoinsList(): List<CoinInfoEntity>

    fun getSavedCoinInfo(coinName: String): CoinInfoEntity
}