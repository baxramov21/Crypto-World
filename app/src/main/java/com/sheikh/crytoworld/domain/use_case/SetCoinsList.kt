package com.sheikh.crytoworld.domain.use_case

import com.sheikh.crytoworld.domain.entity.CoinInfoEntity
import com.sheikh.crytoworld.domain.Repository

class SetCoinsList(private val repository: Repository) {
    operator fun invoke(coinsList: List<CoinInfoEntity>) = repository.setCoinsList(coinsList)
}