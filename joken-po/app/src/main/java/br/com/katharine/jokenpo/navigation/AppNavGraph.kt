package br.com.katharine.jokenpo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import br.com.katharine.jokenpo.ui.screens.JoKenPokemonScreen
import br.com.katharine.jokenpo.ui.screens.PlayerNameScreen

@Composable
fun AppNavGraph(
    // componente que ajuda na navegação do app
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Input.route
    ) {
        // ensina como é a tela de startDestination
        composable(route = Routes.Input.route) {
            PlayerNameScreen {
                navController.navigate(Routes.Result.createRoute(it))
            }
        }

        // ensina como é as demais telas
        composable(
            route = Routes.Result.route, arguments = listOf(
            navArgument(Routes.Result.Args.PROFILE_NAME) {
                type = NavType.StringType
                defaultValue = "profileName"
            }
        )) {
            val profileName = it.arguments?.getString(Routes.Result.Args.PROFILE_NAME)
            JoKenPokemonScreen(profileName!!) {
                navController.popBackStack()
            }
        }
    }
}