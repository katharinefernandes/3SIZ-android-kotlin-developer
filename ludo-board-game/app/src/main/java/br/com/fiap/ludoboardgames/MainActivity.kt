package br.com.fiap.ludoboardgames

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.ludoboardgames.ui.components.GameSearchBar
import br.com.fiap.ludoboardgames.ui.theme.LudoBoardGamesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LudoBoardGamesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GameScreen(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun GameScreen(modifier: Modifier = Modifier) {
    var searchTextState by remember { mutableStateOf("") }
    var searchExample by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            "BoardGames",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))


        GameSearchBar(
            searchText = searchTextState,
            onSearchTextChange = {
                searchTextState = it
            },
            label = "Nome do jogo",
            onSearch = {
                // Buscar os dados pesquisados
                searchExample = it
            },
            onClear = {
                searchTextState = ""
                searchExample = ""
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Texto pesquisado: $searchExample")
    }
}

@Preview(showBackground = true)
@Composable
fun GameScreenPreview(modifier: Modifier = Modifier) {
    LudoBoardGamesTheme {
        GameScreen()
    }
}