package com.example.cryptoinfoapp.ui.screens.detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoinfoapp.data.api.CryptoService
import com.example.cryptoinfoapp.data.models.CurrencyItem
import com.example.cryptoinfoapp.data.util.Resource
import kotlinx.coroutines.launch

class DetailViewModel(
): ViewModel() {

    val service = CryptoService.create()
    var currency: MutableState<CurrencyItem> = mutableStateOf(CurrencyItem())
    var errorMessage: MutableState<String> = mutableStateOf("")

    fun getCurrencyDetails(symbol: String){
        viewModelScope.launch {
            val response = service.getCryptoDetails(symbol)
            if (response is Resource.Success){
                currency.value = response.data!!
            }else{
                errorMessage.value = response.message.toString()
            }
        }
    }
}