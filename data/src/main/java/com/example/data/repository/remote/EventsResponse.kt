package com.example.data.repository.remote

import com.example.domain.model.EventsWrapper
import com.squareup.moshi.Json

data class EventsResponse(
    @Json(name = "i")
    val sportId: String,
    @Json(name = "d")
    val sportName: String,
    @Json(name = "e")
    val events: List<ApiEvent>
)

fun EventsResponse.toEventsWrapper() = EventsWrapper(
    sportId = sportId,
    sportName = sportName,
    events = events.map { it.toEvent() }
)