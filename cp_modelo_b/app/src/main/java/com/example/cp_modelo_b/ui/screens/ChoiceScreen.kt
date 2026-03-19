package com.example.cp_modelo_b.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.cp_modelo_b.data.Characteristic
import com.example.cp_modelo_b.data.starters
import com.example.cp_modelo_b.ui.components.choices.CharacteristicChoiceList

@Composable
fun ChoiceScreen(onNavigateToResult: (Characteristic) -> Unit) {

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center) {
        CharacteristicChoiceList(
            options = starters,
            onSelected = { onNavigateToResult(it) })
    }

}