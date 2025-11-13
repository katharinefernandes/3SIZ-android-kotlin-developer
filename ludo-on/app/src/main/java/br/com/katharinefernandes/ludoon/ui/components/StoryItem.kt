package br.com.katharinefernandes.ludoon.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.katharinefernandes.ludoon.R
import br.com.katharinefernandes.ludoon.ui.models.Story
import br.com.katharinefernandes.ludoon.ui.theme.StoryCircleColor
import br.com.katharinefernandes.ludoon.ui.theme.spacingSmall
import coil.compose.AsyncImage

@Composable
fun StoryItem(story: Story) {
    Column(
        modifier = Modifier
            .padding(spacingSmall)
            .background(MaterialTheme.colorScheme.background)
    ) {
        AsyncImage(
            model = story.userAvatar,
            contentDescription = stringResource(
                R.string.story_content_description,
                story.userNickname
            ),
            modifier = Modifier
                .size(64.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxSize()
                .clip(
                    CircleShape
                )
                .border(2.dp, StoryCircleColor, CircleShape),
            contentScale = ContentScale.Fit,
//            placeholder = painterResource(R.drawable.placeholder),
//            error = painterResource(R.drawable.error)
        )

        Text(
            story.userNickname, modifier = Modifier
                .width(72.dp)
                .height(24.dp),
            style = MaterialTheme.typography.labelSmall,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun StoryItemPreview(modifier: Modifier = Modifier) {
    StoryItem(Story("", ""))
}