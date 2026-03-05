package br.com.katharine.jokenpo.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun PokemonLogo(
    imgLogo: Int,
    label: String
) {
    Image(
        painter = painterResource(id = imgLogo),
        contentDescription = label,
        modifier = Modifier.height(100.dp)
    )
}