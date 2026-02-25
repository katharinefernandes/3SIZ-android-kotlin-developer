package br.com.katharinefernandes.lotteryapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.katharinefernandes.lotteryapp.ui.theme.LotteryAppTheme

@Composable
fun NumberAmountScreen(onNavigateToGenerateNumbers: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Gerador de Loteria",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                onNavigateToGenerateNumbers(6)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Gerar números")
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun NumberAmountScreenPreview() {
    LotteryAppTheme {
        NumberAmountScreen {

        }
    }
}