package br.com.katharinefernandes.jokenpo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import br.com.katharinefernandes.jokenpo.ui.screens.JoKenPokemonScreen
import br.com.katharinefernandes.jokenpo.ui.screens.PlayerNameScreen

@Composable
fun AppNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Routes.Input.route
    ) {

        composable(route = Routes.Input.route) {
            PlayerNameScreen {
                navController.navigate(Routes.Result.createRoute(it))
            }
        }

        composable(
            route = Routes.Result.route, arguments = listOf(
                navArgument(Routes.Result.Args.PLAYER_NAME) {
                    type = NavType.StringType
                    defaultValue = "playerName"
                }
            )) {
            val playerName = it.arguments?.getString(Routes.Result.Args.PLAYER_NAME)
            JoKenPokemonScreen(playerName!!) {
                navController.popBackStack()
            }
        }
    }


}