package com.example.sports_events.helper.ext

import com.example.domain.model.Sport
import com.example.sports_events.ui.model.SportUi

fun Sport.toSportUi() = SportUi(
    sportId = sportId,
    sportName = sportName,
    events = events.map { it.toEventUi() }
)