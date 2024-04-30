package com.example.sports_events.ui.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class EventUi(
    val eventId: String,
    val sportId: String,
    val firstCompetitor: String,
    val secondCompetitor: String,
    val timestamp: Long,
    val isFavorite: MutableState<Boolean> = mutableStateOf(false)
)