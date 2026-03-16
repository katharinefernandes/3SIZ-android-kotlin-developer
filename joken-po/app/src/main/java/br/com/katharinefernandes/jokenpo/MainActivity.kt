package br.com.katharinefernandes.jokenpo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import br.com.katharine.jokenpo.ui.theme.JokenpoTheme
import br.com.katharinefernandes.jokenpo.navigation.AppNavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JokenpoTheme {
                AppNavGraph(rememberNavController())
            }
        }
    }
}