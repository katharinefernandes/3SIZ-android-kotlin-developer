package br.com.rm552673_rm552664_gs2.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.rm552673_rm552664_gs2.ui.model.Category

@Composable
fun CategoryCard(
    categoryPublisher: Category,
    onClick: ((Category) -> Unit)? = null
) {
    Card(
        modifier = Modifier
            .size(120.dp)
            .clickable(enabled = onClick != null) {
                onClick?.invoke(categoryPublisher)
            },
        elevation =
            CardDefaults.cardElevation(
                defaultElevation =
                    4.dp
            )
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement =
                Arrangement.Center,
            horizontalAlignment =
                Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(categoryPublisher.imageRes),
                contentDescription = categoryPublisher.title,
                modifier = Modifier.size(56.dp)
            )

            Text(
                categoryPublisher.title, textAlign =
                    TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        }

    }
}