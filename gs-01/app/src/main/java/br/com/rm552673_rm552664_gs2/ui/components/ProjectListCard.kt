package br.com.rm552673_rm552664_gs2.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.rm552673_rm552664_gs2.ui.model.Project

@Composable
fun ProjectListCard(project: Project) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF8F9FE)),
        border = BorderStroke(1.dp, Color(0xFFE6ECEC))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
                ) {
                Image(
                    painter = painterResource(project.imgRes),
                    contentDescription = project.name,
                    modifier = Modifier.size(100.dp),
                    alignment = Alignment.Center
                )

                Text(
                    text = project.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = project.description,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = "Vale até ${project.points.toString()} pontos de engajamento",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis
                )
            }

        }
    }
}