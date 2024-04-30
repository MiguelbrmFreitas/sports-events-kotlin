package com.example.data.repository

import com.example.data.repository.local.database.FavoriteEventsDatabase
import com.example.data.repository.local.entity.FavoriteEventEntity
import com.example.data.repository.local.entity.toFavoriteEventList
import com.example.data.repository.remote.SportsService
import com.example.data.repository.remote.model.toSport
import com.example.domain.core.ResponseStatus
import com.example.domain.model.Event
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

    override suspend fun addFavoriteEvent(event: Event) {
        database.favoriteEventsDao().addEvent(
            FavoriteEventEntity(
                eventId = event.eventId,
                sportId = event.sportId
            )
        )
    }

}