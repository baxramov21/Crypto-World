package com.sheikh.crytoworld.data.network

import com.sheikh.crytoworld.data.network.dto.CoinPriceInfoRawDataDto
import com.sheikh.crytoworld.data.network.dto.TopCoinsListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(TOP_COINS_LINK)
    fun getTopCoins(
        @Query(QUERY_PARAM_API_KEY) api_key: String = QUERY_VALUE_API_KEY,
        @Query(QUERY_PARAM_LIMIT) limit: Int = QUERY_VALUE_LIMIT,
        @Query(QUERY_PARAM_CONVERT_TO) convertingCurrency: String
    ): TopCoinsListDto

    @GET(COIN_DATA_LINK)
    fun getFullDataOfCoins(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = QUERY_VALUE_API_KEY,
        @Query(QUERY_PARAM_COIN_NAME) coinName: String,
        @Query(QUERY_PARAM_CONVERT_VALUE) convertCurrencyName: String,
    ): CoinPriceInfoRawDataDto

    companion object {
        private const val QUERY_PARAM_API_KEY = "api_key"
        private const val QUERY_VALUE_API_KEY =
            "b7b7765290ee735994da05fef8406cebc8e7bf2842d4347b92f157c4ead7c877"

        private const val QUERY_PARAM_LIMIT = "limit"
        private const val QUERY_VALUE_LIMIT = 40

        private const val QUERY_PARAM_CONVERT_TO = "tsym"
        private const val QUERY_VALUE_CONVERT_TO = "USD"

        private const val QUERY_PARAM_COIN_NAME = "fsyms"
        private const val QUERY_PARAM_CONVERT_VALUE = "tsyms"
//        private const val QUERY_VALUE_CONVERT_VALUE = "USD"

        //Links to use in api request
        private const val TOP_COINS_LINK = "top/totalvolfull"
        private const val COIN_DATA_LINK = "pricemultifull"
    }
}