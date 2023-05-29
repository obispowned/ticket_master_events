package com.game.ticketmaster.app.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.game.ticketmaster.app.ui.model.HomeViewModel
import com.game.ticketmaster.app.ui.model.SearchViewModel

@Composable
fun SearchScreen(navController: NavController, searchViewModel: SearchViewModel) {
    Text(text = "SEARCH")
}
