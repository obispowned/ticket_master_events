package com.game.ticketmaster.app.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.game.ticketmaster.app.ui.model.EventsViewModel
import com.game.ticketmaster.app.ui.model.HomeViewModel

@Composable
fun EventsScreen(navController: NavController, eventsViewModel: EventsViewModel) {
    Text(text = "EVENTS")
}