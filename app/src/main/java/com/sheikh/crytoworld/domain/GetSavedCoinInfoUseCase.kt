package com.sheikh.crytoworld.domain

class GetSavedCoinInfoUseCase(private val repository: Repository) {
    operator fun invoke(coinName: String): CoinInfoEntity = repository.getSavedCoinInfo(coinName)
}