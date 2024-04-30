package com.example.data.repository

import com.example.data.repository.remote.SportsService
import com.example.data.repository.remote.model.toSport
import com.example.domain.core.ResponseStatus
import com.example.domain.model.Sport
import com.example.domain.repository.SportsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SportsRepositoryImpl(
    private val service: SportsService
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

}