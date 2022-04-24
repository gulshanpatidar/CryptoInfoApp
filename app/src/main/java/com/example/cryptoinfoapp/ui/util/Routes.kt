package com.example.cryptoinfoapp.ui.util

sealed class Routes(val route: String){
    object Home: Routes("home_screen")
    object Detail: Routes("detail_screen")
}
