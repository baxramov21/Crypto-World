package com.sheikh.crytoworld.domain

class GetSavedCoinsListUseCase(private val repository: Repository) {
    operator fun invoke(): List<CoinInfoEntity> = repository.getSavedCoinsList()
}