package com.example.domain.usecase

import com.example.domain.repository.SportsRepository

class GetSportsUseCase(
    private val repository: SportsRepository
) {

    suspend operator fun invoke() = repository.getSports()

}