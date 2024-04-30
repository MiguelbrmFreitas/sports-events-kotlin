package com.example.data.repository.local.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.repository.local.entity.FavoriteEventEntity

interface FavoriteEventsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addEvent(favoriteEventEntity: FavoriteEventEntity)

    @Query("SELECT * FROM table_favorite_events")
    fun getFavoriteEvents(): List<FavoriteEventEntity>
}