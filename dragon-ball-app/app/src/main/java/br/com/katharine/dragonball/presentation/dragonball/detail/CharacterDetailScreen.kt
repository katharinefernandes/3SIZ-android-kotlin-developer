package br.com.katharine.dragonball.presentation.dragonball.detail

// Manter o package

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import br.com.katharine.dragonball.presentation.common.UiState
import coil3.compose.AsyncImage
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterDetailScreen(
    characterId: Int,
    onBackClick: () -> Unit,
    viewModel: CharacterDetailViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(characterId) {
        viewModel.getCharacterById(characterId)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalhe do Personagem") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->

        Box(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize(),
        ) {
            when (val state = uiState) {
                UiState.Initial -> Unit

                UiState.Loading -> {
                    CircularProgressIndicator()
                }

                is UiState.Error -> {
                    Text(state.message)
                }

                is UiState.Success -> {
                    val character = state.data

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight() // ocupa altura disponível
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            AsyncImage(
                                model = character.image,
                                contentDescription = character.name,
                                modifier = Modifier.size(160.dp),
                                contentScale = ContentScale.Fit
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            Text(
                                text = character.name,
                                style = MaterialTheme.typography.headlineMedium
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Text("Id: ${character.id}")
                        }
                    }
                }
            }
        }
    }
}