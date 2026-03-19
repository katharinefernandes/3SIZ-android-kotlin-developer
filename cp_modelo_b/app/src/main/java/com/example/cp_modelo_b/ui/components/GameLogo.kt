package com.example.cp_modelo_b.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun GameLogo(imgLogo: Int, label: String, height: Int) {
    Image(
        painter = painterResource(id = imgLogo),
        contentDescription = label,
        modifier = Modifier
            .height(height.dp)
            .padding(16.dp)
    )

}