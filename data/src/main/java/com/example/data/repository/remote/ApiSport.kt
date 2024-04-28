package com.example.data.repository.remote

import com.example.domain.model.Sport
import com.squareup.moshi.Json

data class ApiSports(
    @Json(name = "i")
    val sportId: String,
    @Json(name = "d")
    val sportName: String,
    @Json(name = "e")
    val events: List<ApiEvent>
)

fun ApiSports.toSport() = Sport(
    sportId = sportId,
    sportName = sportName,
    events = events.map { it.toEvent() }
)