package com.game.ticketmaster.app.data

import com.game.ticketmaster.app.data.network.TicketMasterApiService


class EventRepository(private val ticketmasterApiService: TicketMasterApiService) {


    /*suspend fun getEventsByCity(city: String): List<Event> {
        val response = ticketmasterApiService.getEventsByCity(city)
        if (response.isSuccessful) {
            val eventResponse = response.body()
            return eventResponse?.events?.map { event ->
                Event(
                    name = event.name,
                    location = event.location,
                    date = event.date
                )
            } ?: emptyList()
        }
        return emptyList()
    }*/
}