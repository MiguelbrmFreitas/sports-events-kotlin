package com.example.domain.usecase

import com.example.domain.model.FavoriteEvent
import com.example.domain.repository.SportsRepository

class RemoveFavoriteEventUseCase(
    private val repository: SportsRepository
) {
    suspend operator fun invoke(favoriteEvent: FavoriteEvent) {
        repository.removeFavoriteEvent(favoriteEvent)
    }
}