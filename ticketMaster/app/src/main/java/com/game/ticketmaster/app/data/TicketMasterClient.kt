package com.game.ticketmaster.app.data

import com.game.ticketmaster.app.data.network.TicketMasterApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TicketMasterClient {
    private const val BASE_URL = "https://app.ticketmaster.com/discovery/v2/"

    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder().build()
    }

    val ticketmasterApiService: TicketMasterApiService by lazy {
        retrofit.create(TicketMasterApiService::class.java)
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}