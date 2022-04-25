package com.example.cryptoinfoapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.cryptoinfoapp.ui.theme.CryptoInfoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoInfoAppTheme(darkTheme = false) {

                val navController = rememberNavController()
                AppNavigation(navController = navController)
            }
        }
    }
}