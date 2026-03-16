package br.com.katharinefernandes.jokenpo.ui.components.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.katharinefernandes.jokenpo.data.Pokemon

@Composable
fun PokeCard(playerName: String, pokemonSelected: Pokemon) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val playerNameComputer = "Computador"

        if (pokemonSelected.name.isEmpty()) {
            JokeCardItemDefault(playerName)
            JokeCardItemDefault(playerNameComputer)
        } else {
            JokeCardItem(playerName, pokemonSelected)
            JokeCardItem(playerNameComputer, pokemonSelected)
        }
    }
}