package com.example.cryptoinfoapp.ui.screens.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoinfoapp.data.api.CryptoService
import com.example.cryptoinfoapp.data.models.CurrencyItem
import com.example.cryptoinfoapp.data.util.Resource
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {

    private val cryptoService = CryptoService.create()

    var currencies: MutableState<ArrayList<CurrencyItem>> = mutableStateOf(ArrayList())
    var errorMessage: MutableState<String> = mutableStateOf("")

    init {
        getCurrencies()
    }

    fun getCurrencies(){

        viewModelScope.launch {

            val response = cryptoService.getCryptoList()

            if (response is Resource.Success){
                currencies.value = response.data!!
            }else{
                errorMessage.value = response.message.toString()
            }
        }
    }
}