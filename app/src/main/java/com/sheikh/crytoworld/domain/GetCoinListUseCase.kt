package com.sheikh.crytoworld.domain

class GetCoinListUseCase(
    private val repository: Repository
) {
    operator fun invoke() = repository.getCoinsList()
}