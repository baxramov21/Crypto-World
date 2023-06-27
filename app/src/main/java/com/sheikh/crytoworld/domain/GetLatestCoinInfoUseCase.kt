package com.sheikh.crytoworld.domain

class GetLatestCoinInfoUseCase(
    private val repository: Repository
) {
    operator fun invoke(fromSymbol: String) = repository.getLatestCoinInfo(fromSymbol)
}