package com.example.data.repository.remote

import com.example.data.repository.remote.model.ApiSports
import retrofit2.http.GET

interface SportsService {

    @GET("sports")
    suspend fun getSports(): List<ApiSports>

}