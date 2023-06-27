package com.sheikh.crytoworld.domain

import androidx.lifecycle.LiveData

class GetLatestCoinsListUseCase(
    private val repository: Repository
) {
    operator fun invoke(): LiveData<List<CoinInfoEntity>> = repository.getLatestCoinsList()
}