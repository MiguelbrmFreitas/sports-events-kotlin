package com.example.sports_events.ui.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.domain.model.Event

data class SportUi(
    val sportId: String,
    val sportName: String,
    val events: List<Event>,
    var isFavorite: MutableState<Boolean> = mutableStateOf(false),
    var isCollapsed: MutableState<Boolean> = mutableStateOf(true)
)