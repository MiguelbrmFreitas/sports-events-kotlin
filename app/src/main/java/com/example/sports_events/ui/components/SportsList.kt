package com.example.sports_events.ui.components

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.domain.model.Sport
import androidx.compose.foundation.lazy.items

@Composable
fun SportsList(
    sports: List<Sport>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
    ) {
        items(sports) { sport ->
            SportItem(sport = sport)
        }
    }
}