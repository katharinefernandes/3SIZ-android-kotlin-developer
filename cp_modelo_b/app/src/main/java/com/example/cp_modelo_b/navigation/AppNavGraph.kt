package com.example.cp_modelo_b.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import br.com.katharinefernandes.jokenpo.navigation.Routes
import com.example.cp_modelo_b.ui.screens.HomeScreen
import com.example.cp_modelo_b.ui.screens.ResultScreen
import com.example.cp_modelo_b.R
import com.example.cp_modelo_b.ui.screens.ChoiceScreen

@Composable
fun AppNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Routes.Input.route
    ) {

        composable(route = Routes.Input.route) {
            HomeScreen {
                navController.navigate(Routes.Choice.route)
            }
        }

        composable(route = Routes.Choice.route) {
            ChoiceScreen {
                navController.navigate(Routes.Result.createRoute(it.name, it.imageHouseRes))
            }
        }


        composable(
            route = Routes.Result.route, arguments = listOf(
                navArgument(Routes.Result.Args.HOUSE_NAME) {
                    type = NavType.StringType
                    defaultValue = "Casa Default"
                },
                navArgument(Routes.Result.Args.IMAGE) {
                    type = NavType.IntType
                    defaultValue = R.drawable.house_martell
                }
            )
        ) {
            val houseName = it.arguments?.getString(Routes.Result.Args.HOUSE_NAME) ?: "Casa Default"
            val image = it.arguments?.getInt(Routes.Result.Args.IMAGE) ?: R.drawable.house_martell
            ResultScreen(houseName, image)
        }
    }


}