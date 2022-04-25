package com.example.cryptoinfoapp.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cryptoinfoapp.ui.components.ScaffoldUse
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun HomeScreen(viewModel: HomeViewModel, onClickTopButton: () -> Unit,onClickCurrency: (symbol: String) -> Unit) {

    val isRefreshing by viewModel.isRefreshing.collectAsState()

    ScaffoldUse(topBarTitle = "CryptoInfo", onClickTopButton = { onClickTopButton() }) {
        val currencies by remember {
            viewModel.currencies
        }

        SwipeRefresh(state = rememberSwipeRefreshState(isRefreshing = isRefreshing), onRefresh = { viewModel.getCurrencies() }) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(currencies.size) {
                    val currency = currencies[it]
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                onClickCurrency(currency.symbol)
                            }
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row {
                            Text(
                                text = currency.baseAsset + " / ",
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = currency.quoteAsset,
                                fontSize = 18.sp
                            )
                        }
                        Text(
                            text = currency.lastPrice,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Divider()
                }
            }
        }
    }
}