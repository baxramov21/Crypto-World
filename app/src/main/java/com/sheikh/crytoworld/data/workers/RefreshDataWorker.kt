package com.sheikh.crytoworld.data.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkerParameters
import com.sheikh.crytoworld.data.converters.Mapper
import com.sheikh.crytoworld.data.database.AppDatabase
import com.sheikh.crytoworld.data.network.ApiFactory
import kotlinx.coroutines.delay
import java.io.IOException

class RefreshDataWorker(
    context: Context,
    workerParameters: WorkerParameters
) : CoroutineWorker(context, workerParameters) {

    private val db = AppDatabase.getInstance(context).getDao()
    private val mapper = Mapper()
    private val api = ApiFactory.api

    override suspend fun doWork(): Result {
        while (true) {
            try {
//                val topCoins =
//                    api.getTopCoins(limit = topCoinsLimit, convertingCurrency = convertTo)
                val topCoins =
                    api.getTopCoins(limit = 40, convertingCurrency = "USD")
                val fromSymbols = mapper.mapNamesListToString(topCoins)
                val json = api.getFullDataOfCoins(coinName = fromSymbols)
                val coinsInfoList = mapper.mapJsonContainerToListCoinInfo(json)
                val coinDbModelList = mapper.dtoListToDbModelList(coinsInfoList)
                db.addCoinsList(coinDbModelList)
            } catch (exception: IOException) {
                Log.e(NAME, "Check your internet connection")
            }
            delay(10000)
        }
    }

    companion object {

        const val NAME = "CoroutineWorker"
        fun makeRequest(): OneTimeWorkRequest =
            OneTimeWorkRequestBuilder<RefreshDataWorker>().build()
    }
}