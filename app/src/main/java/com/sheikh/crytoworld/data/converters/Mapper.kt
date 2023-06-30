package com.sheikh.crytoworld.data.converters

import com.sheikh.crytoworld.data.database.db_model.coin_full_info.CoinInfoDbModel
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

    fun entityToDbModel(entity: CoinInfoEntity): CoinInfoDbModel {
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
}