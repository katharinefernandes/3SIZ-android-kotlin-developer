package br.com.katharinefernandes.lotteryapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.katharinefernandes.lotteryapp.ui.screens.NumberAmountScreen
import br.com.katharinefernandes.lotteryapp.ui.screens.ResultScreen

@Composable
fun AppNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "input"
    ) {
        composable(route = "input") {
            navController.navigate("result")
        }
        composable(route = "result") {
            ResultScreen(6)
        }
    }
}