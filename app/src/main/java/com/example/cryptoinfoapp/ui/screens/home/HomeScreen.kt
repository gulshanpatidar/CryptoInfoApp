package com.example.cryptoinfoapp.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(viewModel: HomeViewModel) {

    val currencies by remember {
        viewModel.currencies
    }

    LazyColumn() {
        items(currencies.size) {
            Row(horizontalArrangement = Arrangement.SpaceBetween) {

                Text(
                    text = currencies[it].symbol,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = currencies[it].lastPrice,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}