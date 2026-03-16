package br.com.katharinefernandes.jokenpo.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.katharine.jokenpo.ui.theme.JokenpoTheme
import br.com.katharinefernandes.jokenpo.R
import br.com.katharinefernandes.jokenpo.data.Pokemon
import br.com.katharinefernandes.jokenpo.data.starters
import br.com.katharinefernandes.jokenpo.ui.components.PokeLogo
import br.com.katharinefernandes.jokenpo.ui.components.ReturnButton
import br.com.katharinefernandes.jokenpo.ui.components.cards.JokeCardItem
import br.com.katharinefernandes.jokenpo.ui.components.cards.JokeCardItemDefault
import br.com.katharinefernandes.jokenpo.ui.components.cards.PokeCard
import br.com.katharinefernandes.jokenpo.ui.components.options.PokemonOptionsList

@Composable
fun JoKenPokemonScreen(playerName: String, onBackPressed: () -> Unit) {

    var pokemonSelected by rememberSaveable(
        stateSaver = Saver(save = {
            listOf(
                it.name, it.imageRes
            )
        }, restore = {
            Pokemon(
                name = it[0] as String,
                imageRes = it[1] as Int,
            )
        })
    ) {
        mutableStateOf(Pokemon())
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PokeLogo(
                imgLogo = R.drawable.logo_pokemon,
                label = "Logo com escrita Pokemon",
                height = 130
            )
            ReturnButton(onBackPressed)
        }
        PokeCard(playerName, pokemonSelected)
        PokemonOptionsList(
            options = starters,
            pokemonSelected = pokemonSelected,
            onSelected = { pokemonSelected = it })
    }

}

@Preview
@Composable
private fun JoKenPokemonScreenPreview() {
    JokenpoTheme {
        JoKenPokemonScreen("playerName") {

        }
    }

}