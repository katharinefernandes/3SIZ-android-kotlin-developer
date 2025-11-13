package br.com.rm552673_rm552664_gs2.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import br.com.rm552673_rm552664_gs2.R
import br.com.rm552673_rm552664_gs2.ui.theme.fontXXLarge

@Composable
fun AppLogo() {
    Text(
        text = stringResource(R.string.app_name),
        style = TextStyle(
            fontSize = fontXXLarge,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif
        )
    )
}

@Preview(showBackground = true)
@Composable
fun AppLogoPreview(modifier: Modifier = Modifier) {
    AppLogo()
}