package com.example.pokemonstarterselection

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokemonstarterselection.ui.theme.PokemonStarterSelectionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokemonStarterSelectionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PokemonStarterScreen(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

// armazena dados, evita escrever toString(), equals(), hashCode() e copy()
data class Pokemon(
    val name: String = "", val imageRes: Int = R.drawable.pokeball_unselected
)

val starters = listOf(
    Pokemon("Bulbasaur", R.drawable.bulbassaur),
    Pokemon("Charmander", R.drawable.charmander),
    Pokemon("Squirtle", R.drawable.squirtle)
)

@Composable
fun PokemonStarterScreen(
    modifier: Modifier = Modifier
) {
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

    val config = LocalConfiguration.current
    val isPortrait = config.orientation == Configuration.ORIENTATION_PORTRAIT

    if (isPortrait) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            PokeLogo(imgLogo = R.drawable.logo_pokemon, label = "Logo Pokémon")
            PokeHeader("Escolha seu Pokémon inicial")
            PokemonCard(pokemonSelected)
            PokemonOptionList(
                options = starters,
                pokemonSelected = pokemonSelected,
                onSelected = { pokemonSelected = it })
        }
    } else {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // pokemon selecionado a esquerda
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                PokeLogo(imgLogo = R.drawable.logo_pokemon, label = "Logo Pokémon")
                PokemonCard(pokemon = pokemonSelected)
            }
            // opções na direita
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Column {
                    PokeHeader("Escolha seu Pokémon inicial")
                    Spacer(modifier = Modifier.height(32.dp))
                    PokemonOptionList(
                        options = starters,
                        pokemonSelected,
                        onSelected = { pokemonSelected = it }
                    )
                }
            }
        }
    }

}

@Composable
fun PokeHeader(
    label: String,
) {
    Text(
        text = label,
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun PokeLogo(
    imgLogo: Int,
    label: String
) {
    Image(
        painter = painterResource(id = imgLogo),
        contentDescription = label,
        modifier = Modifier.height(50.dp)
    )
}

@Composable
fun PokemonCard(pokemon: Pokemon) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = pokemon.imageRes),
            contentDescription = pokemon.name,
            modifier = Modifier.size(250.dp)
        )
        Text(
            text = pokemon.name.uppercase(),
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

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
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = if (selected) painterResource(id = R.drawable.pokeball_selected) else painterResource(
                id = R.drawable.pokeball_unselected
            ),
            contentDescription = pokemon.name,
            modifier = Modifier.size(40.dp),
            colorFilter = if (isSystemInDarkTheme() && !selected) ColorFilter.tint(Color.White) else null
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = pokemon.name, fontSize = 18.sp)
    }
}

@Composable
fun PokemonOptionList(
    options: List<Pokemon>,
    pokemonSelected: Pokemon,
    onSelected: (Pokemon) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
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

