package com.example.cryptoinfoapp.data.api

import com.example.cryptoinfoapp.data.models.CurrencyItem
import com.example.cryptoinfoapp.data.util.Resource

interface CryptoService {

    suspend fun getCryptoList(): Resource<CurrencyItem>

    suspend fun getCryptoDetails(): Resource<CurrencyItem>

    companion object{

    }
}