package com.sheikh.crytoworld.domain.use_case

import com.sheikh.crytoworld.domain.entity.CoinInfoEntity
import com.sheikh.crytoworld.domain.Repository

class GetSavedCoinInfo(private val repository: Repository) {
    operator fun invoke(coinName: String): CoinInfoEntity = repository.getSavedCoinInfo(coinName)
}