package com.example.cryptoinfoapp.data.api

import com.example.cryptoinfoapp.data.CryptoServiceImpl
import com.example.cryptoinfoapp.data.models.CurrencyItem
import com.example.cryptoinfoapp.data.util.Resource
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*

interface CryptoService {

    suspend fun getCryptoList(): Resource<ArrayList<CurrencyItem>>

    suspend fun getCryptoDetails(currencySymbol: String): Resource<CurrencyItem>

    companion object{

        fun create(): CryptoService{
            return CryptoServiceImpl(
                client = HttpClient(Android){
                    install(Logging){
                        level = LogLevel.ALL
                    }
                    install(JsonFeature){
                        serializer = KotlinxSerializer(kotlinx.serialization.json.Json{
                            ignoreUnknownKeys = true
                            coerceInputValues = true
                        })
                    }
                }
            )
        }
    }
}