package com.example.cryptoinfoapp.ui.screens.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.cryptoinfoapp.ui.components.ScaffoldUse

@Composable
fun DetailScreen(symbol: String,viewModel: DetailViewModel, onClickTopButton: () -> Unit) {

    viewModel.getCurrencyDetails(symbol)

    val currency by remember {
        viewModel.currency
    }

    ScaffoldUse(topBarTitle = currency.symbol, onClickTopButton = { onClickTopButton() }) {

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Text(
                    text = currency.baseAsset + " / ",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = currency.quoteAsset,
                    fontSize = 26.sp
                )
            }
        }
    }
}