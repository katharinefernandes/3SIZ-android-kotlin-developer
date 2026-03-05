package br.com.katharine.jokenpo.navigation

sealed class Routes(val route: String) {
    object Input : Routes("input")
    object Result :
        Routes("result/{${Args.PROFILE_NAME}}") {

        object Args {
            const val PROFILE_NAME = "profileName"
        }

        fun createRoute(profileName: String) =
            "result/$profileName"
    }
}