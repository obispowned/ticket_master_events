package com.game.ticketmaster.app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.game.ticketmaster.app.ui.EventsScreen
import com.game.ticketmaster.app.ui.HomeScreen
import com.game.ticketmaster.app.ui.ProfileScreen
import com.game.ticketmaster.app.ui.SearchScreen
import com.game.ticketmaster.app.ui.model.EventsViewModel
import com.game.ticketmaster.app.ui.model.HomeViewModel
import com.game.ticketmaster.app.ui.model.ProfileViewModel
import com.game.ticketmaster.app.ui.model.SearchViewModel

@Composable
fun HomeNav(navController: NavHostController, homeViewModel: HomeViewModel){
    HomeScreen(navController, homeViewModel)
}

@Composable
fun EventsNav(navController: NavHostController, eventsViewModel: EventsViewModel){
    EventsScreen(navController, eventsViewModel)
}

@Composable
fun ProfileNav(navController: NavHostController, profileViewModel: ProfileViewModel){
    ProfileScreen(navController, profileViewModel)
}

@Composable
fun SearchNav(navController: NavHostController, searchViewModel: SearchViewModel){
    SearchScreen(navController, searchViewModel)
}