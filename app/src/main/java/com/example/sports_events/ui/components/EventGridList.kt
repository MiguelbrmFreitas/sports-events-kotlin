package com.example.sports_events.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.model.Event
import com.example.sports_events.R
import com.example.sports_events.ui.model.EventUi


@Composable
fun EventGrid(
    eventList: List<EventUi>,
    onToggleFavorite: (EventUi) -> Unit,
    onStartCountDownTimer: (EventUi) -> Unit
) {
    if(eventList.isNotEmpty()) {
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
    } else {
        Text(
            text = stringResource(id = R.string.empty_events),
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 16.dp)
        )
    }
}