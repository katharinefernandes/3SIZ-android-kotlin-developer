package br.com.rm552673.rm552852


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.rm552673.rm552852.repository.getAllAgencies
import br.com.rm552673.rm552852.repository.getAllServices
import br.com.rm552673.rm552852.ui.components.SectionHeader
import br.com.rm552673.rm552852.ui.components.SectionServicesCardList
import br.com.rm552673.rm552852.ui.theme.CPCTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CPCTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TravelScreen(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun TravelScreen(modifier: Modifier = Modifier) {

    var travelAgencieState by remember { mutableStateOf(getAllAgencies()) }
    var servicesState by remember { mutableStateOf(getAllServices()) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            "Fiapp Travel",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1976D2)
        )


        Spacer(modifier = Modifier.height(30.dp))

        LazyRow(
            contentPadding = PaddingValues(
                horizontal = 16.dp
            ),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(travelAgencieState) { travelAgencie ->
                SectionHeader(travelAgencie.logoImg, travelAgencie.title)
            }

        }

        Spacer(modifier = Modifier.height(30.dp))

        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)) {
            items(servicesState) { service ->
                SectionServicesCardList(service)
            }
        }

    }
}