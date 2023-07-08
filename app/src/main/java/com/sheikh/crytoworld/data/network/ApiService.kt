package com.sheikh.crytoworld.data.network

import com.sheikh.crytoworld.data.network.dto.CoinInfoJsonContainer
import com.sheikh.crytoworld.data.network.dto.TopCoinNamesDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(TOP_COINS_LINK)
    suspend fun getTopCoins(
//        @Query(QUERY_PARAM_API_KEY) api_key: String = QUERY_VALUE_API_KEY,
        @Query(QUERY_PARAM_LIMIT) limit: Int,
        @Query(QUERY_PARAM_CONVERT_TO) convertingCurrency: String = QUERY_VALUE_CONVERT_TO
    ): TopCoinNamesDto

    @GET(COIN_DATA_LINK)
    suspend fun getFullDataOfCoins(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = QUERY_VALUE_API_KEY,
        @Query(QUERY_PARAM_COIN_NAME) coinName: String,
        @Query(QUERY_PARAM_CONVERT_VALUE) convertCurrencyName: String = QUERY_VALUE_CONVERT_TO,
    ): CoinInfoJsonContainer

    companion object {
        private const val QUERY_PARAM_API_KEY = "api_key"
        private const val QUERY_VALUE_API_KEY = ""

        private const val QUERY_PARAM_LIMIT = "limit"

        private const val QUERY_PARAM_CONVERT_TO = "tsym"
        private const val QUERY_VALUE_CONVERT_TO = "USD"

        private const val QUERY_PARAM_COIN_NAME = "fsyms"
        private const val QUERY_PARAM_CONVERT_VALUE = "tsyms"

        //Links to use in api request
        private const val TOP_COINS_LINK = "top/totalvolfull?"
        private const val COIN_DATA_LINK = "pricemultifull"
    }
}