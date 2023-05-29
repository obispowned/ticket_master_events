package com.game.ticketmaster.app.data.network

import com.game.ticketmaster.app.core.ApiKeyProvider
import com.game.ticketmaster.app.data.model.EventResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TicketMasterApiService {
    @GET("events.json?")
    suspend fun getEventsByCity(
        @Query("city") city: String,
        @Query("apikey") apiKey: String = ApiKeyProvider.TICKETMASTER_API_KEY,
        @Query("sort") sort: String = "date,asc",
        @Query("page") page: Int = 0,
        @Query("size") size: Int = 50
    ): Response<EventResponse>
}