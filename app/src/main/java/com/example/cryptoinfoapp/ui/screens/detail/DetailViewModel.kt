package com.example.cryptoinfoapp.ui.screens.detail

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoinfoapp.data.api.CryptoService
import com.example.cryptoinfoapp.data.models.CurrencyItem
import kotlinx.coroutines.launch

class DetailViewModel(
    private val symbol: String
): ViewModel() {

    val service = CryptoService.create()
    lateinit var currency: MutableState<CurrencyItem>

    init {
        getCurrencyDetails()
    }

    fun getCurrencyDetails(){
        viewModelScope.launch {
            currency.value = service.getCryptoDetails(symbol).data!!
        }
    }
}