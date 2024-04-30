package com.example.domain.model

data class Sport(
    val sportId: String,
    val sportName: String,
    val events: List<Event>,
    var isFavorite: Boolean = false,
    var isCollapsed: Boolean = true
)