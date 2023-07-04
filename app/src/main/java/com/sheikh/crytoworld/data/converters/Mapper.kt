package com.sheikh.crytoworld.data.converters

import com.google.gson.Gson
import com.sheikh.crytoworld.data.database.db_model.CoinInfoDbModel
import com.sheikh.crytoworld.data.network.dto.CoinInfoDto
import com.sheikh.crytoworld.data.network.dto.CoinInfoJsonContainer
import com.sheikh.crytoworld.data.network.dto.TopCoinNamesDto
import com.sheikh.crytoworld.domain.entity.CoinInfoEntity

class Mapper {

    fun dbModelToEntity(dbModel: CoinInfoDbModel): CoinInfoEntity {
        return CoinInfoEntity(
            market = dbModel.market,
            type = dbModel.type,
            fromSymbol = dbModel.fromSymbol,
            toSymbol = dbModel.toSymbol,
            price = dbModel.price,
            lastUpdate = dbModel.lastUpdate,
            lastTradeId = dbModel.lastTradeId,
            highDay = dbModel.highDay,
            lowDay = dbModel.lowDay,
            lastMarket = dbModel.lastMarket,
            highHour = dbModel.highHour,
            lowHour = dbModel.lowHour,
            imageUrl = dbModel.imageUrl
        )
    }

    private fun entityToDbModel(entity: CoinInfoEntity): CoinInfoDbModel {
        return CoinInfoDbModel(
            market = entity.market,
            type = entity.type,
            fromSymbol = entity.fromSymbol,
            toSymbol = entity.toSymbol,
            price = entity.price,
            lastUpdate = entity.lastUpdate,
            lastTradeId = entity.lastTradeId,
            highDay = entity.highDay,
            lowDay = entity.lowDay,
            lastMarket = entity.lastMarket,
            highHour = entity.highHour,
            lowHour = entity.lowHour,
            imageUrl = entity.imageUrl
        )
    }

    fun entityListToDbModelList(entities: List<CoinInfoEntity>): List<CoinInfoDbModel> =
        entities.map { entityToDbModel(it) }

    fun dbModelListToEntityList(databaseModels: List<CoinInfoDbModel>): List<CoinInfoEntity> =
        databaseModels.map { dbModelToEntity(it) }

    private fun dbModelToDto(dbModel: CoinInfoDbModel): CoinInfoDto {
        return CoinInfoDto(
            market = dbModel.market,
            type = dbModel.type,
            fromSymbol = dbModel.fromSymbol,
            toSymbol = dbModel.toSymbol,
            price = dbModel.price,
            lastUpdate = dbModel.lastUpdate,
            lastTradeId = dbModel.lastTradeId,
            highDay = dbModel.highDay,
            lowDay = dbModel.lowDay,
            lastMarket = dbModel.lastMarket,
            highHour = dbModel.highHour,
            lowHour = dbModel.lowHour,
            imageUrl = dbModel.imageUrl
        )
    }

    private fun dtoToDbModel(dto: CoinInfoDto): CoinInfoDbModel {
        return CoinInfoDbModel(
            market = dto.market!!,
            type = dto.type!!,
            fromSymbol = dto.fromSymbol!!,
            toSymbol = dto.toSymbol!!,
            price = dto.price!!,
            lastUpdate = dto.lastUpdate!!,
            lastTradeId = dto.lastTradeId!!,
            highDay = dto.highDay!!,
            lowDay = dto.lowDay!!,
            lastMarket = dto.lastMarket!!,
            highHour = dto.highHour!!,
            lowHour = dto.lowHour!!,
            imageUrl = dto.imageUrl!!
        )
    }

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

    fun dtoListToDbModelList(topCoinsList: List<CoinInfoDto>): List<CoinInfoDbModel> =
        topCoinsList.map { dtoToDbModel(it) }

    fun dbModelListToDtoList(databaseModels: List<CoinInfoDbModel>): List<CoinInfoDto> =
        databaseModels.map { dbModelToDto(it) }

    fun mapNamesListToString(topCoinNames: TopCoinNamesDto): String {
        return topCoinNames.topCoinNames?.map {
            it.coinName?.name
        }?.joinToString ( "," ) ?: ""
    }
}