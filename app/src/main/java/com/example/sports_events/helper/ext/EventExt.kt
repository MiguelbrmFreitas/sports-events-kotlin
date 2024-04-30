package com.example.sports_events.helper.ext

import com.example.domain.model.Event
import com.example.sports_events.ui.model.EventUi

fun Event.toEventUi() = EventUi(
    eventId = eventId,
    sportId = sportId,
    firstCompetitor = firstCompetitor,
    secondCompetitor = secondCompetitor,
    timestamp = timestamp
)