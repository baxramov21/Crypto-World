package com.sheikh.crytoworld.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.sheikh.crytoworld.data.converters.Mapper
import com.sheikh.crytoworld.data.database.AppDatabase
import com.sheikh.crytoworld.data.network.ApiFactory
import com.sheikh.crytoworld.data.workers.RefreshDataWorker
import com.sheikh.crytoworld.domain.entity.CoinInfoEntity
import com.sheikh.crytoworld.domain.repository.Repository
import kotlinx.coroutines.delay
import java.io.IOException

private const val TAG = "RepositoryImpl"

class RepositoryImpl(private val context: Context) : Repository {

    private val db = AppDatabase.getInstance(context).getDao()
    private val mapper = Mapper()
    private val api = ApiFactory.api

    override fun getCoinsList(): LiveData<List<CoinInfoEntity>> {
        return MediatorLiveData<List<CoinInfoEntity>>().apply {
            addSource(db.getCoinsList()) {
                value = mapper.dbModelListToEntityList(it)
            }
        }
    }

    override suspend fun getCoinInfo(coinName: String): CoinInfoEntity =
        mapper.dbModelToEntity(db.getCoin(coinName))


    override fun loadData(topCoinsLimit: Int, convertTo: String) {
        val workerManager = WorkManager.getInstance(context)
        workerManager.enqueueUniqueWork(
            RefreshDataWorker.NAME,
            ExistingWorkPolicy.REPLACE,
            RefreshDataWorker.makeRequest()
        )
    }
}