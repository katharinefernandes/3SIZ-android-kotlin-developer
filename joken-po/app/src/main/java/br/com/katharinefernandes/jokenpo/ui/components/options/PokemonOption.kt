package br.com.katharinefernandes.jokenpo.ui.components.options

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.katharinefernandes.jokenpo.R
import br.com.katharinefernandes.jokenpo.data.Pokemon

@Composable
fun PokemonOption(
    selected: Boolean,
    pokemon: Pokemon,
    onSelected: (Pokemon) -> Unit
) {


    Column(
        modifier = Modifier
            .clickable { onSelected(pokemon) }
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = if (selected) painterResource(id = R.drawable.pokeball_selected) else painterResource(
                id = R.drawable.pokeball_unselected
            ),
            contentDescription = pokemon.name,
            modifier = Modifier.size(30.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = pokemon.name, fontSize = 12.sp)

    }

}