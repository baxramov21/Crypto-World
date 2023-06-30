package com.sheikh.crytoworld.domain.use_case

import com.sheikh.crytoworld.domain.Repository

class GetLatestCoinInfo(
    private val repository: Repository
) {
    operator fun invoke(fromSymbol: String) = repository.getLatestCoinInfo(fromSymbol)
}