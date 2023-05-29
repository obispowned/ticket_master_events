package com.game.ticketmaster.app.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route:String, val title:String, val icon: ImageVector){
    object Home : BottomNavItem("home", "Home", Icons.Default.Home)
    object Events: BottomNavItem("events", "Eventos", Icons.Default.Event)
    object Profile: BottomNavItem("profile", "Mi perfil", Icons.Default.Person)
    object Search: BottomNavItem("search","Búsqueda",Icons.Default.Search)
}