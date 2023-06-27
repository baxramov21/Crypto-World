package com.sheikh.crytoworld.data

import androidx.lifecycle.LiveData
import com.sheikh.crytoworld.domain.CoinInfoEntity
import com.sheikh.crytoworld.domain.Repository

class RepositoryImpl : Repository {

    override fun getLatestCoinsList(): LiveData<List<CoinInfoEntity>> {
        TODO("Not yet implemented")
    }

    override fun getLatestCoinInfo(coinName: String): LiveData<CoinInfoEntity> {
        TODO("Not yet implemented")
    }

    override fun getSavedCoinsList(): List<CoinInfoEntity> {
        TODO("Not yet implemented")
    }

    override fun getSavedCoinInfo(coinName: String): CoinInfoEntity {
        TODO("Not yet implemented")
    }
}