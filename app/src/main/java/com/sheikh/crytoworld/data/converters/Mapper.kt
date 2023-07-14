package com.sheikh.crytoworld.data.converters

import com.google.gson.Gson
import com.sheikh.crytoworld.data.database.db_model.CoinInfoDbModel
import com.sheikh.crytoworld.data.network.dto.CoinInfoDto
import com.sheikh.crytoworld.data.network.dto.CoinInfoJsonContainer
import com.sheikh.crytoworld.data.network.dto.TopCoinNamesDto
import com.sheikh.crytoworld.domain.entity.CoinInfoEntity
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

class Mapper {

    fun dbModelToEntity(dbModel: CoinInfoDbModel): CoinInfoEntity {
        return CoinInfoEntity(
            market = dbModel.market,
            type = dbModel.type,
            fromSymbol = dbModel.fromSymbol,
            toSymbol = dbModel.toSymbol,
            price = dbModel.price,
            lastUpdate = convertTimeStampToTime(dbModel.lastUpdate),
            lastTradeId = dbModel.lastTradeId,
            highDay = dbModel.highDay,
            lowDay = dbModel.lowDay,
            lastMarket = dbModel.lastMarket,
            highHour = dbModel.highHour,
            lowHour = dbModel.lowHour,
            imageUrl = dbModel.imageUrl
        )
    }

    fun dbModelListToEntityList(databaseModels: List<CoinInfoDbModel>): List<CoinInfoEntity> =
        databaseModels.map { dbModelToEntity(it) }

    private fun dtoToDbModel(dto: CoinInfoDto): CoinInfoDbModel {
        return CoinInfoDbModel(
            market = dto.market,
            type = dto.type,
            fromSymbol = dto.fromSymbol,
            toSymbol = dto.toSymbol,
            price = dto.price,
            lastUpdate = dto.lastUpdate,
            lastTradeId = dto.lastTradeId,
            highDay = dto.highDay,
            lowDay = dto.lowDay,
            lastMarket = dto.lastMarket,
            highHour = dto.highHour,
            lowHour = dto.lowHour,
            imageUrl = BASE_IMAGE_URL + dto.imageUrl
        )
    }

    fun dtoListToDbModelList(topCoinsList: List<CoinInfoDto>): List<CoinInfoDbModel> =
        topCoinsList.map { dtoToDbModel(it) }

    fun mapJsonContainerToListCoinInfo(jsonContainer: CoinInfoJsonContainer): List<CoinInfoDto> {
        val result = mutableListOf<CoinInfoDto>()
        val jsonObject = jsonContainer.coinNameJsonObject ?: return result
        val coinKeySet = jsonObject.keySet()
        for (coinKey in coinKeySet) {
            val currencyJson = jsonObject.getAsJsonObject(coinKey)
            val currencyKeySet = currencyJson.keySet()
            for (currencyKey in currencyKeySet) {
                val priceInfo = Gson().fromJson(
                    currencyJson.getAsJsonObject(currencyKey),
                    CoinInfoDto::class.java
                )
                result.add(priceInfo)
            }
        }
        return result
    }


    fun mapNamesListToString(topCoinNames: TopCoinNamesDto): String {
        return topCoinNames.topCoinNames?.map {
            it.coinName?.name
        }?.joinToString(",") ?: ""
    }

    private fun convertTimeStampToTime(timeStamp: Long?): String {
        if (timeStamp == null) return ""
        val stamp = Timestamp(timeStamp * 1000)
        val date = Date(stamp.time)
        val pattern = "HH:mm:ss"
        val sdf = SimpleDateFormat(pattern, Locale.getDefault())
        sdf.timeZone = TimeZone.getDefault()
        return sdf.format(date)
    }

    companion object {
        const val BASE_IMAGE_URL = "https://cryptocompare.com"
    }
}