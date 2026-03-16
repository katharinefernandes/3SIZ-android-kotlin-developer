package br.com.katharinefernandes.jokenpo.ui.components.options

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.katharinefernandes.jokenpo.data.Pokemon

@Composable
fun PokemonOptionsList(
    options: List<Pokemon>,
    pokemonSelected: Pokemon,
    onSelected: (Pokemon) -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Faça sua jogada de mestre", fontWeight = FontWeight.Bold, fontSize = 12.sp)
        Row(
            horizontalArrangement = Arrangement.spacedBy(32.dp),
        ) {
            options.forEach { pokemon ->
                PokemonOption(
                    pokemon = pokemon,
                    selected = pokemon == pokemonSelected,
                    onSelected = onSelected
                )
            }
        }
    }
}