package br.com.rm552673_rm552664_gs2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import br.com.rm552673_rm552664_gs2.ui.screens.HomeScreen
import br.com.rm552673_rm552664_gs2.ui.theme.GamefyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GamefyTheme {
                HomeScreen()
            }
        }
    }
}