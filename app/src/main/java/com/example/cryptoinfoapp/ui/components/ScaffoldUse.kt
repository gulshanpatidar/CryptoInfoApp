package com.example.cryptoinfoapp.ui.components

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable

@Composable
fun ScaffoldUse(
    topBarTitle: String,
    onClickTopButton:() -> Unit,
    content: @Composable () -> Unit
) {

    Scaffold(
        topBar ={
            TopBar(title = topBarTitle) {
                onClickTopButton()
            }
        }
    ) {
        content()
    }
}