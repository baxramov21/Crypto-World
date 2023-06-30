package com.sheikh.crytoworld.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.sheikh.crytoworld.data.converters.Mapper
import com.sheikh.crytoworld.data.database.AppDatabase
import com.sheikh.crytoworld.domain.entity.CoinInfoEntity
import com.sheikh.crytoworld.domain.Repository

class RepositoryImpl(private val context: Context) : Repository {

    private val db = AppDatabase.getInstance(context).getDao()
    private val mapper = Mapper()

    override fun getLatestCoinsList(): LiveData<List<CoinInfoEntity>> {
        TODO("Not yet implemented")
    }

    override fun getLatestCoinInfo(coinName: String): LiveData<CoinInfoEntity> {
        TODO("Not yet implemented")
    }

    override fun getSavedCoinsList(): LiveData<List<CoinInfoEntity>> {
       return MediatorLiveData<List<CoinInfoEntity>>().apply {
            addSource(db.getCoinsList()) {
                value = mapper.dbModelListToEntityList(it)
            }
        }
    }

    override fun getSavedCoinInfo(coinName: String): CoinInfoEntity {
        TODO("Not yet implemented")
    }

    override fun setCoinsList(coinsList: List<CoinInfoEntity>) {
        TODO("Not yet implemented")
    }
}