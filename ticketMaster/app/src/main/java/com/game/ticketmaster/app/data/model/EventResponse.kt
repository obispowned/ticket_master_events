package com.game.ticketmaster.app.data.model

import com.google.gson.annotations.SerializedName

data class EventResponse (

    @SerializedName("_links") var links : Links,
    @SerializedName("_embedded") var embedded : Embedded,
    @SerializedName("page") var page : Page

)