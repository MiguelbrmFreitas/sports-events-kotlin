package com.example.domain.usecase

import com.example.domain.repository.SportsRepository

class GetFavoriteEventsUseCase(
    private val repository: SportsRepository
) {

    suspend operator fun invoke() = repository.getFavoriteEvents()

}