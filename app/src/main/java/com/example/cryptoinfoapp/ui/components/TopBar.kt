package com.example.cryptoinfoapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun TopBar(
    title: String,
    onTopButtonClicked: () -> Unit
) {
    TopAppBar(
        title = {
            Text(text = title)
        },
        navigationIcon = {
            if (title != "CryptoInfo") {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Button to go back",
                    modifier = Modifier
                        .clickable(onClick = onTopButtonClicked)
                        .padding(horizontal = 12.dp)
                        .size(30.dp),
                    tint = Color.White
                )
            }
        },
        backgroundColor = MaterialTheme.colors.primary
    )
}