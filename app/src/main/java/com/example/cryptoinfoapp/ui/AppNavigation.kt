package com.example.cryptoinfoapp.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.cryptoinfoapp.ui.screens.detail.DetailScreen
import com.example.cryptoinfoapp.ui.screens.detail.DetailViewModel
import com.example.cryptoinfoapp.ui.screens.home.HomeScreen
import com.example.cryptoinfoapp.ui.screens.home.HomeViewModel
import com.example.cryptoinfoapp.ui.util.Routes

@Composable
fun AppNavigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Routes.Home.route) {

        composable(Routes.Home.route) {

            val viewModel = viewModel<HomeViewModel>()

            HomeScreen(viewModel = viewModel,{  }) { symbol ->
                navController.navigate(Routes.Detail.route + "/$symbol")
            }
        }

        composable(route = Routes.Detail.route + "/{symbol}", arguments = listOf(
            navArgument(name = "symbol") {
                NavType.StringType
            }
        )) { navBackStackEntry ->
            val symbol = navBackStackEntry.arguments?.getString("symbol").toString()
            val detailViewModel: DetailViewModel = viewModel()
            DetailScreen(symbol = symbol, viewModel = detailViewModel) {
                navController.navigateUp()
            }
        }
    }
}