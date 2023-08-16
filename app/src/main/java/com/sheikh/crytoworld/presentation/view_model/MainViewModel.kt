package com.sheikh.crytoworld.presentation.view_model

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sheikh.crytoworld.data.repository.RepositoryImpl
import com.sheikh.crytoworld.domain.entity.CoinInfoEntity
import com.sheikh.crytoworld.domain.use_case.GetCoinInfo
import com.sheikh.crytoworld.domain.use_case.GetCoinsList
import com.sheikh.crytoworld.domain.use_case.LoadData

class MainViewModel(application: Application) : ViewModel() {


    private val repository = RepositoryImpl(application)

    private val dataLoader = LoadData(repository)
    private val getCoinInfo = GetCoinInfo(repository)
    private val getCoinsList = GetCoinsList(repository)

    val topCoins: LiveData<List<CoinInfoEntity>> = getCoinsList()

    suspend fun getCoin(coinName: String): CoinInfoEntity {
        return getCoinInfo.getCoinInfo(coinName)
    }

    fun startLoading() {
        dataLoader.loadData(COINS_LIMIT, QUERY_VALUE_CONVERT_TO)
    }

    companion object {
        private const val COINS_LIMIT = 40
        private const val QUERY_VALUE_CONVERT_TO = "USD"
    }
}