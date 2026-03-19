package com.example.cp_modelo_b.ui.components.choices

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cp_modelo_b.data.Characteristic

@Composable
fun CharacteristicChoice(
    characteristic : Characteristic,
    onSelected: (Characteristic) -> Unit
) {

    Column(
        modifier = Modifier
            .clickable { onSelected(characteristic) }
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = characteristic.imageHouseSymbRes),
            contentDescription = characteristic.name,
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = characteristic.name, fontSize = 18.sp)

    }

}