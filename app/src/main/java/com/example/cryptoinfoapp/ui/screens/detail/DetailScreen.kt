package com.example.cryptoinfoapp.ui.screens.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cryptoinfoapp.ui.components.ScaffoldUse
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun DetailScreen(symbol: String, viewModel: DetailViewModel, onClickTopButton: () -> Unit) {

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
            Spacer(modifier = Modifier.height(20.dp))
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
            val formatter = SimpleDateFormat("HH:mm:ss", Locale.ENGLISH)
            val time = formatter.format(Date(currency.at))
            Spacer(modifier = Modifier.height(50.dp))
            Row {
                Text(
                    text = "Last updated : $time",
                    fontSize = 20.sp
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Text(
                    text = "Price : ",
                    fontSize = 20.sp
                )
                Text(
                    text = currency.lastPrice,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Text(
                    text = "Highest Price : ",
                    fontSize = 20.sp
                )
                Text(
                    text = currency.highPrice,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Text(
                    text = "Lowest Price : ",
                    fontSize = 20.sp
                )
                Text(
                    text = currency.lowPrice,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Text(
                    text = "Volume : ",
                    fontSize = 20.sp
                )
                Text(
                    text = currency.volume,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}