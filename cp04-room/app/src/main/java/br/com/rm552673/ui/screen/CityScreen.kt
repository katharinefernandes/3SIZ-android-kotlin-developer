package br.com.rm552673.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.rm552673.ui.components.CityItem
import br.com.rm552673.ui.components.CityListHeader
import br.com.rm552673.ui.components.EmptyState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityScreen(viewModel: CityViewModel) {

    var name by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    val cities by viewModel.cities.collectAsState(initial = emptyList())
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(topBar = {
        TopAppBar(
            title = { Text("✈ Cidades Visitadas ") },
            actions = {
                IconButton(onClick = { showDialog = true }) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Limpar tudo"
                    )
                }
            }
        )
    }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {

            Row(verticalAlignment = Alignment.CenterVertically) {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Nome da Cidade") },
                    leadingIcon = {
                        Icon(Icons.Default.LocationOn, contentDescription = null)
                    },
                    modifier = Modifier.weight(1f),
                    singleLine = true
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                OutlinedTextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Descrição da Cidade") },
                    leadingIcon = {
                        Icon(Icons.Default.Edit, contentDescription = null)
                    },
                    modifier = Modifier.weight(1f),
                    singleLine = true
                )
                Spacer(modifier = Modifier.width(8.dp))
                IconButton(onClick = {
                    if (name.isNotEmpty() && description.isNotEmpty()) {
                        viewModel.addCity(name, description)
                        name = ""
                        description = ""
                    }
                }
                ) { Icon(Icons.Default.Add, contentDescription = null) }
            }


            Spacer(modifier = Modifier.height(20.dp))
            if (cities.isEmpty()) {
                EmptyState()
            } else {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    item {
                        CityListHeader(cities.size)
                    }
                    items(cities) { city ->
                        CityItem(
                            city = city,
                            onCheckedChange = { checked ->
                                viewModel.onCityChecked(city, checked)
                            },
                            onDelete = {
                                viewModel.removeCity(city)
                            }
                        )
                    }
                }
            }

        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                confirmButton = {
                    TextButton(onClick = {
                        viewModel.clearAllCities()
                        showDialog = false
                    }
                    ) { Text("Confirmar") }
                },
                dismissButton = {
                    TextButton(
                        onClick = { showDialog = false }
                    ) { Text("Cancelar") }
                },
                title = { Text("Excluir tudo") },
                text = { Text("Deseja apagar todas as cidades?") }
            )
        }


    }
}