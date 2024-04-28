package com.example.data.repository.remote

import com.squareup.moshi.Json

data class EventsResponse(
    @Json(name = "i")
    val sportId: String,
    @Json(name = "d")
    val sportName: String,
    @Json(name = "e")
    val events: ArrayList<ApiEvent>
)
