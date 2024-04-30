package com.example.data.repository.local.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.repository.local.entity.EventEntity
import com.example.domain.model.Event

interface EntityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addEvent(eventEntity: EventEntity)

    @Query("SELECT * FROM table_favorite_events")
    fun getFavoriteEvents(): List<EventEntity>
}