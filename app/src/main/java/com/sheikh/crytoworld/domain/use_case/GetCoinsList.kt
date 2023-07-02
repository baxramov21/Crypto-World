package com.sheikh.crytoworld.domain.use_case

import androidx.lifecycle.LiveData
import com.sheikh.crytoworld.domain.entity.CoinInfoEntity
import com.sheikh.crytoworld.domain.repository.Repository

class GetCoinsList(
    private val repository: Repository
) {
    operator fun invoke(): LiveData<List<CoinInfoEntity>> = repository.getCoinsList()
}