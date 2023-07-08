package com.sheikh.crytoworld.domain.use_case

import com.sheikh.crytoworld.domain.repository.Repository

class GetCoinInfo(
    private val repository: Repository
) {
    suspend fun getCoinInfo(fromSymbol: String) = repository.getCoinInfo(fromSymbol)
}