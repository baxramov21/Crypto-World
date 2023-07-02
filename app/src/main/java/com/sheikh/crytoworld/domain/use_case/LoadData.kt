package com.sheikh.crytoworld.domain.use_case

import com.sheikh.crytoworld.domain.repository.Repository

class LoadData(private val repository: Repository) {
    suspend fun loadData(apiKey: String, topCoinsLimit: Int, convertTo: String) =
        repository.loadData(apiKey, topCoinsLimit, convertTo)
}