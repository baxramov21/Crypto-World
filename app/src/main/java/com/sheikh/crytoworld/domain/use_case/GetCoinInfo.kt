package com.sheikh.crytoworld.domain.use_case

import com.sheikh.crytoworld.domain.repository.Repository

class GetCoinInfo(
    private val repository: Repository
) {
    operator fun invoke(fromSymbol: String) = repository.getCoinInfo(fromSymbol)
}