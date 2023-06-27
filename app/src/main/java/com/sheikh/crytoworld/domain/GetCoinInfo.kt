package com.sheikh.crytoworld.domain

import androidx.lifecycle.LiveData

class GetCoinInfo(
    private val repository: Repository
) {
    operator fun invoke(fromSymbol: String) = repository.getCoinInfo(fromSymbol)
}