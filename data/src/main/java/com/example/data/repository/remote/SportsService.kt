package com.example.data.repository.remote

import retrofit2.http.GET

interface SportsService {

    @GET("sports")
    suspend fun getSports(): List<ApiSports>

}