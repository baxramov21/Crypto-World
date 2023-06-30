package com.sheikh.crytoworld.domain.use_case

import androidx.lifecycle.LiveData
import com.sheikh.crytoworld.domain.entity.CoinInfoEntity
import com.sheikh.crytoworld.domain.Repository

class GetSavedCoinsList(private val repository: Repository) {
    operator fun invoke(): LiveData<List<CoinInfoEntity>> = repository.getSavedCoinsList()
}