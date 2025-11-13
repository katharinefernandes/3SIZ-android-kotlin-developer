package br.com.rm552673_rm552664_gs2.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import br.com.rm552673_rm552664_gs2.ui.theme.iconTopBar

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun GamefyTopAppBar(
    modifier: Modifier = Modifier,
    onRefreshClick: () -> Unit = {},
    refreshIcon: ImageVector = Icons.Default.Refresh,
) {
    val colors = TopAppBarDefaults.topAppBarColors(
        containerColor = MaterialTheme.colorScheme.background
    )

    TopAppBar(
        modifier = modifier,
        colors = colors,
        title = { AppLogo() },
        actions = {
            IconButton(onClick = onRefreshClick) {
                Icon(
                    imageVector = refreshIcon,
                    contentDescription = "Refresh",
                    modifier = Modifier.size(iconTopBar)
                )
            }
        }

    )
}