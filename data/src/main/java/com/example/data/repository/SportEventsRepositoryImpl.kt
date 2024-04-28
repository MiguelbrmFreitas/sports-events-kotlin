package com.example.data.repository

import com.example.data.repository.remote.SportEventsService
import com.example.data.repository.remote.toEventsWrapper
import com.example.domain.model.EventsWrapper
import com.example.domain.repository.SportEventsRepository

class SportEventsRepositoryImpl(
    private val service: SportEventsService
): SportEventsRepository {

    override suspend fun getSportEvents(): EventsWrapper {
        return service.getSportEvents().toEventsWrapper()
    }

}