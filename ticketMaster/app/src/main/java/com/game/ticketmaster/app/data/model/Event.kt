package com.game.ticketmaster.app.data.model

import com.google.gson.annotations.SerializedName

data class Events(
    @SerializedName("name") var name: String,
    @SerializedName("type") var type: String,
    @SerializedName("id") var id: String,
    @SerializedName("venue") var venue: Venues,
    @SerializedName("test") var test: Boolean,
    @SerializedName("url") var url: String,
    @SerializedName("locale") var locale: String,
    @SerializedName("images") var images: List<Images>,
    @SerializedName("sales") var sales: Sales,
    @SerializedName("dates") var dates: Dates,
    @SerializedName("classifications") var classifications: List<Classifications>,
    @SerializedName("promoter") var promoter: Promoter,
    @SerializedName("_links") var Links: Links,
    @SerializedName("_embedded") var Embedded: Embedded
)

data class Address(
    @SerializedName("line1") var line1: String
)

data class Attractions(
    @SerializedName("name") var name: String,
    @SerializedName("type") var type: String,
    @SerializedName("id") var id: String,
    @SerializedName("test") var test: Boolean,
    @SerializedName("locale") var locale: String,
    @SerializedName("images") var images: List<Images>,
    @SerializedName("classifications") var classifications: List<Classifications>,
    @SerializedName("_links") var Links: Links
)

data class City(
    @SerializedName("name") var name: String
)

data class Classifications(
    @SerializedName("primary") var primary: Boolean,
    @SerializedName("segment") var segment: Segment,
    @SerializedName("genre") var genre: Genre,
    @SerializedName("subGenre") var subGenre: SubGenre
)

data class Country(
    @SerializedName("name") var name: String,
    @SerializedName("countryCode") var countryCode: String
)

data class Dates(
    @SerializedName("start") var start: Start
)

data class Embedded(

    @SerializedName("events") var events: List<Events>

)

data class Genre (

    @SerializedName("id") var id : String,
    @SerializedName("name") var name : String

)

data class  Images (
    @SerializedName("url") var url : String,
)

data class Links (

    @SerializedName("self") var self : Self

)

data class Location (

    @SerializedName("longitude") var longitude : String,
    @SerializedName("latitude") var latitude : String

)

data class Markets (

    @SerializedName("id") var id : String

)

data class Next (

    @SerializedName("href") var href : String,
    @SerializedName("templated") var templated : Boolean

)

data class Page (

    @SerializedName("size") var size : Int,
    @SerializedName("totalElements") var totalElements : Int,
    @SerializedName("totalPages") var totalPages : Int,
    @SerializedName("number") var number : Int

)

data class Promoter (

    @SerializedName("id") var id : String

)

data class Public(

    @SerializedName("startDateTime") var startDateTime: String,
    @SerializedName("startTBD") var startTBD: Boolean,
    @SerializedName("endDateTime") var endDateTime: String

)

data class ResponseBody (

    @SerializedName("_links") var Links : Links,
    @SerializedName("_embedded") var Embedded : Embedded,
    @SerializedName("page") var page : Page

)


data class Sales (

    @SerializedName("public") var public : Public

)
data class Segment (

    @SerializedName("id") var id : String,
    @SerializedName("name") var name : String

)
data class Self (

    @SerializedName("href") var href : String

)
data class Start(

    @SerializedName("localDate") var localDate: String,
    @SerializedName("dateTBD") var dateTBD: Boolean,
    @SerializedName("dateTBA") var dateTBA: Boolean,
    @SerializedName("dateTime") var dateTime: String,
    @SerializedName("timeTBA") var timeTBA: Boolean,
    @SerializedName("noSpecificTime") var noSpecificTime: Boolean

)
data class State (

    @SerializedName("name") var name : String,
    @SerializedName("stateCode") var stateCode : String

)
data class Status(
    @SerializedName("code") var code: String
)

data class SubGenre (
    @SerializedName("id") var id : String,
    @SerializedName("name") var name : String
)
data class Venues (
    @SerializedName("name") var name : String,
    @SerializedName("type") var type : String,
    @SerializedName("id") var id : String,
    @SerializedName("test") var test : Boolean,
    @SerializedName("locale") var locale : String,
    @SerializedName("postalCode") var postalCode : String,
    @SerializedName("timezone") var timezone : String,
    @SerializedName("city") var city : City,
    @SerializedName("state") var state : State,
    @SerializedName("country") var country : Country,
    @SerializedName("address") var address : String,
    @SerializedName("location") var location : Location,
    @SerializedName("markets") var markets : List<Markets>,
    @SerializedName("_links") var Links : Links

)

data class Area (
    @SerializedName("name") var name : String
)