package com.example.cryptoinfoapp.ui.screens.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoinfoapp.data.api.CryptoService
import com.example.cryptoinfoapp.data.models.CurrencyItem
import com.example.cryptoinfoapp.data.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {

    private val cryptoService = CryptoService.create()

    var currencies: MutableState<ArrayList<CurrencyItem>> = mutableStateOf(ArrayList())
    var errorMessage: MutableState<String> = mutableStateOf("")

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> = _isRefreshing.asStateFlow()

    init {
        getCurrencies()
    }

    fun getCurrencies(){

        viewModelScope.launch {

            _isRefreshing.emit(true)

            val response = cryptoService.getCryptoList()

            if (response is Resource.Success){
                currencies.value = response.data!!
                _isRefreshing.emit(false)
            }else{
                errorMessage.value = response.message.toString()
                _isRefreshing.emit(false)
            }
        }
    }
}