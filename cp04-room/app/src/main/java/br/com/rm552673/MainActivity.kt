package br.com.rm552673

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.room.Room
import br.com.rm552673.feature.cities.data.local.db.AppDatabase
import br.com.rm552673.feature.cities.data.local.repository.CityRepository
import br.com.rm552673.ui.screen.CityScreen
import br.com.rm552673.ui.screen.CityViewModel
import br.com.rm552673.ui.theme.CP04RoomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val db = Room.databaseBuilder(
            applicationContext, AppDatabase::class.java, "city_db"
        ).build()
        val repository = CityRepository(db.cityDao())
        val viewModel = CityViewModel(repository)
        setContent {
            CP04RoomTheme {
                CityScreen(viewModel)
            }
        }
    }
}