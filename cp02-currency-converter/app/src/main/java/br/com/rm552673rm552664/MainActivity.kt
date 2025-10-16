package br.com.rm552673rm552664

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.rm552673rm552664.ui.theme.CPMODELOCONVERSORMOEDATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CPMODELOCONVERSORMOEDATheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CurrencyConverterScreen(Modifier.padding(innerPadding))

                }
            }
        }
    }
}

@Composable
fun CurrencyConverterScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        var brl by remember { mutableStateOf("") }
        var brlError by remember { mutableStateOf("") }
        var resultUsd by remember { mutableStateOf("") }
        var resultEur by remember { mutableStateOf("") }

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Header("Conversor de Moeda", R.drawable.ic_gold)
            Spacer(modifier = Modifier.height(16.dp))

            val context = LocalContext.current

            OutlinedTextField(
                prefix = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_money),
                        contentDescription = "Valor em R$",
                        modifier = Modifier.size(30.dp).padding(3.dp)
                    )
                },
                value = brl,
                label = { Text("Valor em R$") },
                keyboardOptions = KeyboardOptions(
                    keyboardType =
                        KeyboardType.Number
                ),
                modifier = Modifier.fillMaxWidth(),
                onValueChange = {
                    brl = it
                    if (brl.isEmpty())
                        brlError = "Informe o valor corretamente"
                    else
                        brlError = ""
                }
            )

            if (brlError.isNotEmpty()) {
                Text(
                    brlError,
                    modifier = Modifier.fillMaxWidth(),
                    style = TextStyle(color = Color.Red)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    if (brl.isEmpty()) {
                        Toast.makeText(
                            context,
                            "Prencha o valor em R$ corretamente!",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    } else {
                        val usd = brl.toFloatOrNull()?.times(0.20f)
                        val eur = brl.toFloatOrNull()?.times(0.18f)

                        resultUsd = context.getString(R.string.result_usd, usd)
                        resultEur = context.getString(R.string.result_eur, eur)
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Calcular")
            }

            OutlinedButton(
                onClick = {
                    brl = ""
                    resultUsd = ""
                    resultEur = ""
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Limpar")
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(resultUsd)
            Text(resultEur)
        }
    }
}

@Composable
fun Header(label: String, imgLogo: Int) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = imgLogo),
            contentDescription = label,
            modifier = Modifier.size(50.dp)
        )
        Text(
            text = label,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}

