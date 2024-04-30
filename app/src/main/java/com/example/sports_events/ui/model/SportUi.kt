package com.example.sports_events.ui.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.domain.model.Event

data class SportUi(
    val sportId: String,
    val sportName: String,
    val events: List<EventUi>,
    val showFavorite: MutableState<Boolean> = mutableStateOf(false),
    val isCollapsed: MutableState<Boolean> = mutableStateOf(true)
)