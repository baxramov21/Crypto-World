package com.sheikh.crytoworld.domain.use_case

import com.sheikh.crytoworld.domain.repository.Repository

class LoadData(private val repository: Repository) {
    fun loadData(topCoinsLimit: Int, convertTo: String) =
        repository.loadData(topCoinsLimit, convertTo)
}