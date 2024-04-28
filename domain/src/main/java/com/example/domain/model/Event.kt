package com.example.domain.model

data class Event(
    val eventId: String,
    val sportId: String,
    val eventName: String,
    val timestamp: Long
)