package com.example.data.repository.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.repository.local.entity.FavoriteEventEntity

@Dao
interface FavoriteEventsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addEvent(favoriteEventEntity: FavoriteEventEntity)

    @Query("SELECT * FROM table_favorite_events")
    suspend fun getFavoriteEvents(): List<FavoriteEventEntity>

    @Delete
    suspend fun deleteEvent(favoriteEventEntity: FavoriteEventEntity)
}