package br.com.katharine.dragonball.presentation.navigation

// Manter seu package

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.katharine.dragonball.presentation.dragonball.detail.CharacterDetailScreen
import br.com.katharine.dragonball.presentation.dragonball.list.CharacterListScreen
import br.com.katharine.dragonball.presentation.dragonball.search.CharacterSearchScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRoutes.CHARACTER_LIST
    ) {
        composable(AppRoutes.CHARACTER_LIST) {
            CharacterListScreen(
                onSearchClick = {
                    navController.navigate(AppRoutes.CHARACTER_SEARCH)
                },
                onCharacterClick = { characterId ->
                    navController.navigate(
                        AppRoutes.characterDetail(characterId)
                    )
                }
            )
        }

        composable(AppRoutes.CHARACTER_SEARCH) {
            CharacterSearchScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onSearchCharacterClick = { characterId ->
                    navController.navigate(
                        AppRoutes.characterDetail(characterId)
                    )
                }
            )
        }

        composable(
            route = AppRoutes.CHARACTER_DETAIL,
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val characterId = backStackEntry.arguments?.getInt("characterId") ?: 1

            CharacterDetailScreen(
                characterId = characterId,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}