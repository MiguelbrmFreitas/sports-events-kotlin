package com.example.data.repository.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.model.FavoriteEvent

@Entity(tableName = "table_favorite_events")
data class FavoriteEventEntity(
    @PrimaryKey(autoGenerate = false)
    val eventId: String,
    val sportId: String,
)

fun FavoriteEventEntity.toFavoriteEvent() = FavoriteEvent(
    eventId = eventId,
    sportId = sportId
)

fun List<FavoriteEventEntity>.toFavoriteEventList() =
    this.map {
        it.toFavoriteEvent()
    }