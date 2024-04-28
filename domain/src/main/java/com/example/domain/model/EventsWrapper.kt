package com.example.domain.model

data class EventsWrapper(
    val sportId: String,
    val sportName: String,
    val events: List<Event>
)