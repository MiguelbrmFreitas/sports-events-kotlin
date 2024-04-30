package com.example.data.repository.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_favorite_events")
data class EventEntity(
    @PrimaryKey(autoGenerate = false)
    val eventId: String,
    val sportId: String,
    var isFavorite: Boolean
)