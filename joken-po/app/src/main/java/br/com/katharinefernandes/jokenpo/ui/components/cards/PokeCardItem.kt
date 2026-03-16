package br.com.katharinefernandes.jokenpo.ui.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.katharinefernandes.jokenpo.data.Pokemon

@Composable
fun JokeCardItem(playerName: String, pokemonSelected: Pokemon) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = pokemonSelected.imageRes),
            contentDescription = pokemonSelected.name,
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = pokemonSelected.name, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        Text(text = playerName, fontSize = 12.sp)
    }
}