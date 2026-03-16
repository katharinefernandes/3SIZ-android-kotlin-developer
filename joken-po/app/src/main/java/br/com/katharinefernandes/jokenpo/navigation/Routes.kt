package br.com.katharinefernandes.jokenpo.navigation

sealed class Routes(val route: String) {

    object Input : Routes(
        "input"
    )

    object Result : Routes("result/{${Args.PLAYER_NAME}}") {
        object Args {
            const val PLAYER_NAME = "playerName"
        }
    }

    fun createRoute(playerName: String) =
        "result/$playerName"
}