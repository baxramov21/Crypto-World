package com.sheikh.crytoworld.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.google.gson.Gson
import com.sheikh.crytoworld.data.converters.Mapper
import com.sheikh.crytoworld.data.database.AppDatabase
import com.sheikh.crytoworld.data.network.ApiFactory
import com.sheikh.crytoworld.data.network.dto.CoinFullDataDto
import com.sheikh.crytoworld.data.network.dto.CoinPriceInfoRawDataDto
import com.sheikh.crytoworld.domain.entity.CoinInfoEntity
import com.sheikh.crytoworld.domain.repository.Repository

class RepositoryImpl(private val context: Context) : Repository {

    private val db = AppDatabase.getInstance(context).getDao()
    private val mapper = Mapper()
    private val api = ApiFactory.apiService

    override fun getCoinsList(): LiveData<List<CoinInfoEntity>> {
        return MediatorLiveData<List<CoinInfoEntity>>().apply {
            addSource(db.getCoinsList()) {
                value = mapper.dbModelListToEntityList(it)
            }
        }
    }

    override fun getCoinInfo(coinName: String): LiveData<CoinInfoEntity> {
        return MediatorLiveData<CoinInfoEntity>().apply {
            addSource(db.getCoin(coinName)) {
                value = mapper.dbModelToEntity(it)
            }
        }
    }

    override suspend fun loadData(apiKey: String, topCoinsLimit: Int, convertTo: String) {
        val topCoinsList: String? = api.getTopCoins(apiKey, topCoinsLimit, convertTo)
            .data
            ?.map { it.coinName?.name }?.joinToString { "," }

        topCoinsList?.let {
            val coinPriceInfoRawData: CoinPriceInfoRawDataDto =
                api.getFullDataOfCoins(apiKey, it, convertTo)
            val coinFullDataList =
                convertCoinPriceInfoJsonObjectToCoinFullData(coinPriceInfoRawData)

            db.addCoinsList(
                mapper.dtoListToDbModelList(coinFullDataList)
            )
        }
    }

    private fun convertCoinPriceInfoJsonObjectToCoinFullData(coinPriceInfoRawData: CoinPriceInfoRawDataDto): List<CoinFullDataDto> {
        val result = ArrayList<CoinFullDataDto>()
        val jsonObject = coinPriceInfoRawData.coinNameJsonObject ?: return result
        val coinsKeySet = jsonObject.keySet()
        for (coinKey in coinsKeySet) {
            val currencyJson = jsonObject.getAsJsonObject(coinKey)
            val currencyKeySet = currencyJson.keySet()
            for (currencyKey in currencyKeySet) {
                val coinPriceInfo: CoinFullDataDto = Gson().fromJson(
                    currencyJson.getAsJsonObject(currencyKey),
                    CoinFullDataDto::class.java
                )
                result.add(coinPriceInfo)
            }
        }
        return result
    }
}