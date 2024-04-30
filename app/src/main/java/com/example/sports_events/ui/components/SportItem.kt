package com.example.sports_events.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    onToggleShowFavoriteEventsChanged: (SportUi) -> Unit,
    onStartCountDownTimer: (EventUi) -> Unit
) {
    Column(
        modifier = Modifier
            .background(Color.White),
        verticalArrangement = Arrangement.Center
    ) {
        Divider(
            thickness = 1.dp,
            color = if (isSystemInDarkTheme()) Color.White else Color.Black,
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(
                    top = 8.dp,
                    start = 8.dp,
                    end = 8.dp
                )
                .clickable {
                    onToggleCollapsedChanged(sport)
                }
        ) {
            Row(
                horizontalArrangement = Arrangement.Absolute.Left,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(top = 4.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.circle),
                    contentDescription = stringResource(id = R.string.content_description_circle)
                )
                Text(
                    text = sport.sportName,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
            Row(
                horizontalArrangement = Arrangement.Absolute.Right,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxHeight()
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
        Divider(
            thickness = 1.dp,
            color = Color.Black,
            modifier = Modifier.padding(top = 8.dp)
        )
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
            },
            onStartCountDownTimer = {
                onStartCountDownTimer(it)
            }
        )
    }
}