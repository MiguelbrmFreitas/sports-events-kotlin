package com.example.domain.repository

import com.example.domain.model.EventsWrapper

interface SportEventsRepository {

    suspend fun getSportEvents(): EventsWrapper

}