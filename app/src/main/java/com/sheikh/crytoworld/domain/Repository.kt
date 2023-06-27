package com.sheikh.crytoworld.domain

import androidx.lifecycle.LiveData

interface Repository {
    fun getCoinsList(): LiveData<List<CoinInfo>>

    fun getCoinInfo(fromSymbol: String): LiveData<CoinInfo>
}