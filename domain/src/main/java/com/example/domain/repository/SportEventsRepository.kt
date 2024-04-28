package com.example.domain.repository

import com.example.domain.model.Sport

interface SportEventsRepository {

    suspend fun getSports(): List<Sport>

}