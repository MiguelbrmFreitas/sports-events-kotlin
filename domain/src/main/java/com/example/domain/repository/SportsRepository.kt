package com.example.domain.repository

import com.example.domain.model.Sport

interface SportsRepository {

    suspend fun getSports(): List<Sport>

}