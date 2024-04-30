package com.example.sports_events.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.domain.model.Event
import com.example.sports_events.ui.model.EventUi


@Composable
fun EventGrid(
    eventList: List<EventUi>,
    onToggleFavorite: (EventUi) -> Unit,
    onStartCountDownTimer: (EventUi) -> Unit
) {
    val scrollState = rememberScrollState()

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.heightIn(
            max = 320.dp
        )
    ) {
        items(eventList) { event ->
            EventItem(
                event = event,
                onToggleFavoriteChanged = {
                    onToggleFavorite(it)
                },
                onStartCountDownTimer = {
                    onStartCountDownTimer(it)
                }
            )
        }
    }
}