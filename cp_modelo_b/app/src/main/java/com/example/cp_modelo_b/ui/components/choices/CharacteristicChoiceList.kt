package com.example.cp_modelo_b.ui.components.choices

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cp_modelo_b.data.Characteristic

@Composable
fun CharacteristicChoiceList(
    options: List<Characteristic>,
    onSelected: (Characteristic) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Faça sua escolha", fontWeight = FontWeight.Bold, fontSize = 40.sp)
        options.forEach { ch ->
            CharacteristicChoice(
                characteristic = ch,
                onSelected = onSelected
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}