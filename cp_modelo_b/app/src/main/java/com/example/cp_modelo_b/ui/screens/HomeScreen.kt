package com.example.cp_modelo_b.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cp_modelo_b.ui.components.GameLogo
import com.example.cp_modelo_b.R

@Composable
fun HomeScreen(onNavigateToChoice: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        GameLogo(R.drawable.logo_got, "Logo de Game of Thrones", 300)

        Text("Descubra sua casa em Westeros")

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onNavigateToChoice()
            }) {
            Text("Escolher Característica")
        }
    }

}