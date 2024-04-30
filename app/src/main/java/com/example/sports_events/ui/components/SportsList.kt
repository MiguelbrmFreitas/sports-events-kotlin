package com.example.sports_events.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.domain.model.Sport
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.unit.dp
import com.example.sports_events.ui.model.EventUi
import com.example.sports_events.ui.model.SportUi

@Composable
fun SportsList(
    sports: List<SportUi>,
    onToggleCollapsed: (SportUi) -> Unit,
    onToggleFavorite: (EventUi) -> Unit,
    onToggleShowFavoriteEvents: (SportUi) -> Unit,
    onStartCountDownTimer: (EventUi) -> Unit
) {
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
                }
            )
        }
    }
}