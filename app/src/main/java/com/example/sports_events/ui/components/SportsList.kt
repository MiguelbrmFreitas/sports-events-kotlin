package com.example.sports_events.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.domain.model.Sport
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sports_events.R
import com.example.sports_events.ui.model.EventUi
import com.example.sports_events.ui.model.SportUi

@Composable
fun SportsList(
    sports: List<SportUi>,
    onToggleCollapsed: (SportUi) -> Unit,
    onToggleFavorite: (EventUi) -> Unit,
    onToggleShowFavoriteEvents: (SportUi) -> Unit,
    onStartCountDownTimer: (EventUi) -> Unit,
    filterFavoriteEventsBySport: (SportUi) -> List<EventUi>
) {
    if (sports.isNotEmpty()) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            items(sports) { sport ->
                SportItem(
                    sport = sport,
                    onToggleCollapsedChanged = {
                        onToggleCollapsed(it)
                    },
                    onToggleFavoriteEvent = {
                        onToggleFavorite(it)
                    },
                    onToggleShowFavoriteEventsChanged = {
                        onToggleShowFavoriteEvents(it)
                    },
                    onStartCountDownTimer = {
                        onStartCountDownTimer(it)
                    },
                    filterFavoriteEvents = {
                        filterFavoriteEventsBySport(it)
                    }
                )
            }
        }
    } else {
        Text(
            text = stringResource(id = R.string.empty_events),
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(
                top = 16.dp,
                start = 16.dp,
                end = 16.dp
            )
        )
    }
}