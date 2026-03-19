package br.com.katharinefernandes.jokenpo.navigation

import com.example.cp_modelo_b.data.Characteristic

sealed class Routes(val route: String) {

    object Input : Routes(
        "input"
    )

    object Choice : Routes(
        "choice"
    )

    object Result : Routes("result/{${Args.HOUSE_NAME}}/{${Args.IMAGE}}") {
        object Args {
            const val IMAGE = "choice"
            const val HOUSE_NAME = "houseName"
        }
    }

    fun createRoute(houseName: String, image: Int) =
        "result/$houseName/$image"
}