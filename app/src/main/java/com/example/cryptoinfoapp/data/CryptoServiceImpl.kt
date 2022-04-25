package com.example.cryptoinfoapp.data

import com.example.cryptoinfoapp.data.api.CryptoService
import com.example.cryptoinfoapp.data.models.CurrencyItem
import com.example.cryptoinfoapp.data.util.Resource
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*

class CryptoServiceImpl(
    private val client: HttpClient
) : CryptoService{
    override suspend fun getCryptoList(): Resource<ArrayList<CurrencyItem>> {
        val url = HttpRoutes.BASE_URL
        val currencyReponse = try {
            client.get<ArrayList<CurrencyItem>>(url){
                contentType(ContentType.Application.Json)
            }
        } catch (e: RedirectResponseException) {
            // 3XX responses
            println("Error: ${e.response.status.description}")
            return Resource.Error(message = e.response.status.description)
        } catch (e: ClientRequestException) {
            // 4XX responses
            println("Error: ${e.response.status.description}")
            return Resource.Error(message = e.response.status.description)
        } catch (e: ServerResponseException) {
            // 5XX responses
            println("Error: ${e.response.status.description}")
            return Resource.Error(message = e.response.status.description)
        } catch (e: Exception) {
            println("Error: ${e.message}")
            return Resource.Error(message = e.message.toString())
        }

        return Resource.Success(data = currencyReponse)
    }

    override suspend fun getCryptoDetails(currencySymbol: String): Resource<CurrencyItem> {
        val url = HttpRoutes.CURRENCY_URL
        val currencyResponse = try {
            client.get<CurrencyItem>(url){
                contentType(ContentType.Application.Json)
                parameter("symbol",currencySymbol)
            }
        } catch (e: RedirectResponseException) {
            // 3XX responses
            println("Error: ${e.response.status.description}")
            return Resource.Error(message = e.response.status.description)
        } catch (e: ClientRequestException) {
            // 4XX responses
            println("Error: ${e.response.status.description}")
            return Resource.Error(message = e.response.status.description)
        } catch (e: ServerResponseException) {
            // 5XX responses
            println("Error: ${e.response.status.description}")
            return Resource.Error(message = e.response.status.description)
        } catch (e: Exception) {
            println("Error: ${e.message}")
            return Resource.Error(message = e.message.toString())
        }

        return Resource.Success(data = currencyResponse)
    }
}