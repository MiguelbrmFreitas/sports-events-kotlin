package com.example.domain.usecase

import com.example.domain.core.ResponseStatus
import com.example.domain.model.Sport
import com.example.domain.repository.SportsRepository

class GetSportsUseCase(
    private val repository: SportsRepository
) {
    suspend operator fun invoke(): ResponseStatus<List<Sport>> {
        repository.getSports().also { responseStatus ->
            return when(responseStatus) {
                is ResponseStatus.Success -> {
                    val currentTime = System.currentTimeMillis()/1000L
                    val filteredSports = responseStatus.result.map { sport ->
                        val filteredEvents = sport.events.filter { event ->
                            (event.timestamp - currentTime) >= 0
                        }
                        sport.copy(events = filteredEvents)
                    }
                    ResponseStatus.Success(filteredSports)
                }
                else -> {
                    responseStatus
                }
            }
        }
    }
}