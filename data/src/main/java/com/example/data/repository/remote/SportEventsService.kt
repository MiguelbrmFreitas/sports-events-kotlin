package com.example.data.repository.remote

import retrofit2.http.GET

interface SportEventsService {

    @GET("sports")
    suspend fun getSportEvents(): EventsResponse
}