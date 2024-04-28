package com.example.data.repository.remote

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
