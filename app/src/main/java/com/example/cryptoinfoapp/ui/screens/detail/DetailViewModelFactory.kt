package com.example.cryptoinfoapp.ui.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class DetailViewModelFactory(private val symbol: String): ViewModelProvider.AndroidViewModelFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)){
            return DetailViewModel(symbol) as T
        }
        throw IllegalArgumentException("unknown viewModel class")
    }
}