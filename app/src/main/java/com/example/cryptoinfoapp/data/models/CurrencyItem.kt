package com.example.cryptoinfoapp.data.models

import kotlinx.serialization.Serializable

@Serializable
data class CurrencyItem(
    val askPrice: String ="",
    val at: Long = 0L,
    val baseAsset: String = "",
    val bidPrice: String = "",
    val highPrice: String = "",
    val lastPrice: String = "",
    val lowPrice: String = "",
    val openPrice: String = "",
    val quoteAsset: String = "",
    val symbol: String = "",
    val volume: String = ""
)