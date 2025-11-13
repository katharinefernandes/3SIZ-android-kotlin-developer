package br.com.katharinefernandes.ludoon.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.katharinefernandes.ludoon.ui.models.Story
import br.com.katharinefernandes.ludoon.ui.theme.spacingMedium

@Composable
fun StoryList(stories: List<Story>) {
    LazyRow(modifier = Modifier.padding(top = spacingMedium)) {
        itemsIndexed(stories) { _, story ->
            StoryItem(story)
        }
    }
}