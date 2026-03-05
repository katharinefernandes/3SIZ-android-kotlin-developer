package br.com.katharine.jokenpo.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.katharine.jokenpo.R
import br.com.katharine.jokenpo.ui.components.PokemonLogo
import br.com.katharine.jokenpo.ui.theme.JokenpoTheme

@Composable
fun PlayerNameScreen(modifier: Modifier = Modifier, onNavigateToBattle: (String) -> Unit) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        var playerName by remember { mutableStateOf("") }

        PokemonLogo(imgLogo = R.drawable.logo_pokemon, label = "Logo Pokemon")

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = playerName,
            label = { Text("Digite seu nome") },
            modifier = Modifier.fillMaxWidth(),
            onValueChange = { playerName = it })

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            enabled = playerName.isNotEmpty(),
            onClick = {
                onNavigateToBattle(playerName)
            }, modifier = Modifier.fillMaxWidth()
        ) {
            Text("Iniciar Batalha")
        }

    }
}


@Preview(showBackground = true)
@Composable
private fun ResultScreenPreview() {
    JokenpoTheme {
        PlayerNameScreen {

        }
    }
}