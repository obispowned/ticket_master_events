package com.game.ticketmaster.app.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.game.ticketmaster.app.ui.model.HomeViewModel
import com.game.ticketmaster.app.ui.model.ProfileViewModel

@Composable
fun ProfileScreen(navController: NavController, profileViewModel: ProfileViewModel) {
    Text(text = "PROFILE")
}