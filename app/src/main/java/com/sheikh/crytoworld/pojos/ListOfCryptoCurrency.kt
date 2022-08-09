package com.sheikh.crytoworld.pojos

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




data class ListOfCryptoCurrency (
    @SerializedName("Data")
    @Expose
    private val data: List<Cryptocurrency>? = null
)