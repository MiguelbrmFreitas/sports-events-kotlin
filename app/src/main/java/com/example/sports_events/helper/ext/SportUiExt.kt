package com.example.sports_events.helper.ext

import com.example.sports_events.ui.model.EventUi
import com.example.sports_events.ui.model.SportUi

fun SportUi.filterFavoriteEvents(): List<EventUi> {
    return if (showFavorite.value) {
        events.filter { it.isFavorite.value }
    } else {
        events
    }
}