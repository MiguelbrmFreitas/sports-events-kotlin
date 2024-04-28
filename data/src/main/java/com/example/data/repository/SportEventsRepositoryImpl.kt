package com.example.data.repository

import com.example.data.repository.remote.SportsService
import com.example.data.repository.remote.toSport
import com.example.domain.model.Sport
import com.example.domain.repository.SportEventsRepository

class SportEventsRepositoryImpl(
    private val service: SportsService
): SportEventsRepository {

    override suspend fun getSports(): List<Sport> {
        return service.getSports().map { it.toSport() }
    }

}