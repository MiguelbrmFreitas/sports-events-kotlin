package com.example.data.repository.remote

import com.example.domain.model.Event
import com.squareup.moshi.Json

data class ApiEvent(
    @Json(name = "i")
    val eventId: String,
    @Json(name = "si")
    val sportId: String,
    @Json(name = "d")
    val eventName: String,
    @Json(name="tt")
    val timestamp: Long
)

fun ApiEvent.toEvent() = Event(
    eventId = eventId,
    sportId = sportId,
    eventName = eventName,
    timestamp = timestamp
)
