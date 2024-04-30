package com.example.sports_events.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.model.Sport
import com.example.sports_events.R
import com.example.sports_events.ui.model.EventUi
import com.example.sports_events.ui.model.SportUi

@Composable
fun SportItem(
    sport: SportUi,
    onToggleCollapsedChanged: (SportUi) -> Unit,
    onToggleFavoriteEvent: (EventUi) -> Unit,
    onToggleShowFavoriteEventsChanged: (SportUi) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .clickable {
                onToggleCollapsedChanged(sport)
            }
    ) {
        Row(
            horizontalArrangement = Arrangement.Absolute.Left,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.circle),
                contentDescription = stringResource(id = R.string.content_description_circle)
            )
            Text(
                text = sport.sportName,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        Row(
            horizontalArrangement = Arrangement.Absolute.Right,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val arrowDrawable = if(sport.isCollapsed.value) {
                R.drawable.down_arrow
            } else {
                R.drawable.up_arrow
            }

            val starDrawable = if(sport.showFavorite.value) {
                R.drawable.star_filled
            } else {
                R.drawable.star_empty
            }

            Image(
                painter = painterResource(id = starDrawable),
                contentDescription = stringResource(id = R.string.content_description_star),
                modifier = Modifier
                    .size(32.dp)
                    .padding(end = 8.dp)
                    .clickable {
                        onToggleShowFavoriteEventsChanged(sport)
                    }
            )

            Image(
                painter = painterResource(id = arrowDrawable),
                contentDescription = stringResource(id = R.string.content_description_down_arrow),
                modifier = Modifier.size(16.dp)
            )
        }
    }
    if (!sport.isCollapsed.value) {
        val eventList = if (sport.showFavorite.value) {
            sport.events.filter { it.isFavorite.value }
        } else {
            sport.events
        }

        EventGrid(
            eventList = eventList,
            onToggleFavorite = {
                onToggleFavoriteEvent(it)
            }
        )
    }
}