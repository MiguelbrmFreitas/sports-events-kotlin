package com.example.domain.usecase

import com.example.domain.model.Event
import com.example.domain.repository.SportsRepository

class AddFavoriteEventUseCase(
    private val repository: SportsRepository
) {
    suspend operator fun invoke(event: Event) {
        repository.addFavoriteEvent(event)
    }
}