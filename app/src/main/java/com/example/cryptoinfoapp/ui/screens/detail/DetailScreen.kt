package com.example.cryptoinfoapp.ui.screens.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.*

@Composable
fun DetailScreen(viewModel: DetailViewModel) {

    val currency by remember {
        viewModel.currency
    }
}