package com.example.data.repository

import com.example.data.repository.local.database.FavoriteEventsDatabase
import com.example.data.repository.local.entity.FavoriteEventEntity
import com.example.data.repository.local.entity.toFavoriteEventList
import com.example.data.repository.remote.SportsService
import com.example.data.repository.remote.model.toSport
import com.example.domain.core.ResponseStatus
import com.example.domain.model.FavoriteEvent
import com.example.domain.model.Sport
import com.example.domain.repository.SportsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SportsRepositoryImpl(
    private val service: SportsService,
    private val database: FavoriteEventsDatabase
): SportsRepository {

    override suspend fun getSports(): ResponseStatus<List<Sport>> {
        return withContext(Dispatchers.IO) {
            try {
                ResponseStatus.Success(
                    service.getSports().map { it.toSport() }
                )
            } catch (throwable: Throwable) {
                ResponseStatus.Error(throwable)
            }
        }
    }

    override suspend fun getFavoriteEvents(): List<FavoriteEvent> {
        return database.favoriteEventsDao().getFavoriteEvents().toFavoriteEventList()
    }

    override suspend fun addFavoriteEvent(favoriteEvent: FavoriteEvent) {
        database.favoriteEventsDao().addEvent(
            FavoriteEventEntity(
                eventId = favoriteEvent.eventId,
                sportId = favoriteEvent.sportId
            )
        )
    }

    override suspend fun removeFavoriteEvent(favoriteEvent: FavoriteEvent) {
        database.favoriteEventsDao().deleteEvent(
            FavoriteEventEntity(
                eventId = favoriteEvent.eventId,
                sportId = favoriteEvent.sportId
            )
        )
    }

}