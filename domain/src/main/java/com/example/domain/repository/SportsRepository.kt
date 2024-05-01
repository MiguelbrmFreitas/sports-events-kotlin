package com.example.domain.repository

import com.example.domain.core.ResponseStatus
import com.example.domain.model.Event
import com.example.domain.model.FavoriteEvent
import com.example.domain.model.Sport

interface SportsRepository {

    suspend fun getSports(): ResponseStatus<List<Sport>>

    suspend fun getFavoriteEvents(): List<FavoriteEvent>

    suspend fun addFavoriteEvent(favoriteEvent: FavoriteEvent)

}