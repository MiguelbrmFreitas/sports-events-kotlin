package com.example.data.repository.local.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.repository.local.dao.EntityDao

abstract class FavoriteEventsDatabase : RoomDatabase() {

    abstract fun entityDao(): EntityDao

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