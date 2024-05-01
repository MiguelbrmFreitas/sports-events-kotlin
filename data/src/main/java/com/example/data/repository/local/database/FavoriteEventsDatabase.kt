package com.example.data.repository.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.repository.local.dao.FavoriteEventsDao
import com.example.data.repository.local.entity.FavoriteEventEntity


@Database(
    entities = [FavoriteEventEntity::class],
    version = 3,
    exportSchema = false
)
abstract class FavoriteEventsDatabase : RoomDatabase() {

    abstract fun favoriteEventsDao(): FavoriteEventsDao

    companion object {

        @Volatile
        private var INSTANCE: FavoriteEventsDatabase? = null

        fun getInstance(context: Context): FavoriteEventsDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        FavoriteEventsDatabase::class.java,
                        "favorite_events_db"
                    ).fallbackToDestructiveMigration()
                        .build()
                }

                return instance
            }
        }

    }
}