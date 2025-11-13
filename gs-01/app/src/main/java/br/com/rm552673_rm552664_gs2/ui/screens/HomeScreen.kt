package br.com.rm552673_rm552664_gs2.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import br.com.rm552673_rm552664_gs2.ui.components.CategoryCard
import br.com.rm552673_rm552664_gs2.ui.components.GamefySearchBar
import br.com.rm552673_rm552664_gs2.ui.components.GamefyTopAppBar
import br.com.rm552673_rm552664_gs2.ui.components.ProjectListCard
import br.com.rm552673_rm552664_gs2.ui.repository.getAllCategories
import br.com.rm552673_rm552664_gs2.ui.repository.getAllProjects
import br.com.rm552673_rm552664_gs2.ui.repository.getProjectByCategory
import br.com.rm552673_rm552664_gs2.ui.repository.getProjetByName

@Composable
fun HomeScreen() {

    var searchTextState by remember { mutableStateOf("") }
    var searchExample by remember { mutableStateOf("") }

    var categoryState by remember { mutableStateOf(getAllCategories()) }
    var projectListState by remember { mutableStateOf(getAllProjects()) }

    Scaffold(
        topBar = { GamefyTopAppBar() },
        modifier = Modifier.background(MaterialTheme.colorScheme.background)
    ) { padding ->


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            LazyRow(
                contentPadding = PaddingValues(
                    horizontal = 16.dp
                ),
                horizontalArrangement =
                    Arrangement.spacedBy(16.dp)
            ) {
                items(categoryState) { category ->
                    CategoryCard(category, onClick = {
                        projectListState = getProjectByCategory(it)
                    })
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            GamefySearchBar(
                searchText = searchTextState,
                onSearchTextChange = {
                    searchTextState = it
                },
                label = "Buscar desafio ou categoria",
                onSearch = {
                    projectListState = getProjetByName(it)
                },
                onClear = {
                    searchTextState = ""
                    searchExample = ""
                    projectListState = getAllProjects()
                }
            )

            if (projectListState.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Nenhum desafio encontrado",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            } else {
                Spacer(modifier = Modifier.height(16.dp))
                LazyColumn(modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)) {
                    items(projectListState) { game ->
                        ProjectListCard(game)
                    }
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(modifier: Modifier = Modifier) {
    HomeScreen()
}