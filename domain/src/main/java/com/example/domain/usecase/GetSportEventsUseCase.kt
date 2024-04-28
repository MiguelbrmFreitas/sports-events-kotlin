package com.example.domain.usecase

import com.example.domain.repository.SportEventsRepository

class GetSportEventsUseCase(private val repository: SportEventsRepository) {

    suspend operator fun invoke() = repository.getSports()

}