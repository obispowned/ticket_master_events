package com.game.ticketmaster.app.ui.navigation

sealed class Routes (val route: String) {
    object HomeNav : Routes("HomeNav")
    object EventsNav : Routes("EventsNav")
    object ProfileNav : Routes("ProfileNav")
    object SearchNav : Routes("SearchNav")
}