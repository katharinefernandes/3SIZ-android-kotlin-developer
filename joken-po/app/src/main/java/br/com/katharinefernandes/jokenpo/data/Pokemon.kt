package br.com.katharinefernandes.jokenpo.data

import br.com.katharinefernandes.jokenpo.R

data class Pokemon(
    val name: String = "", val imageRes: Int = R.drawable.pokeball_unselected
)

val starters = listOf(
    Pokemon("Bulbasaur", R.drawable.bulbassaur),
    Pokemon("Charmander", R.drawable.charmander),
    Pokemon("Squirtle", R.drawable.squirtle)
)