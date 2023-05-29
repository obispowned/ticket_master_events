package com.game.ticketmaster

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.game.ticketmaster.app.ui.EventsScreen
import com.game.ticketmaster.app.ui.HomeScreen
import com.game.ticketmaster.app.ui.ProfileScreen
import com.game.ticketmaster.app.ui.SearchScreen
import com.game.ticketmaster.app.ui.model.EventsViewModel
import com.game.ticketmaster.app.ui.model.HomeViewModel
import com.game.ticketmaster.app.ui.model.ProfileViewModel
import com.game.ticketmaster.app.ui.model.SearchViewModel
import com.game.ticketmaster.app.ui.navigation.BottomNavItem
import com.game.ticketmaster.ui.theme.Cyan200
import com.game.ticketmaster.ui.theme.CyanTeal
import com.game.ticketmaster.ui.theme.Teal500
import com.game.ticketmaster.ui.theme.Teal900
import com.game.ticketmaster.ui.theme.TicketMasterTheme
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

class MainActivity : ComponentActivity() {

    private val homeViewModel: HomeViewModel by viewModels()
    private val eventsViewModel: EventsViewModel by viewModels()
    private val profileViewModel: ProfileViewModel by viewModels()
    private val searchViewModel: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicketMasterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    mainScreen()
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun mainScreen() {
        // A surface container using the 'background' color from the theme
        val items = listOf(
            BottomNavItem.Home,
            BottomNavItem.Events,
            BottomNavItem.Profile,
            BottomNavItem.Search
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val navControllerr = rememberNavController()
            Scaffold(
                Modifier.padding(10.dp),
                bottomBar = { MyBottomNavigation(navControllerr, items) }
            ) {
                NavigationGraph(navController = navControllerr)
            }
        }

    }

    @Composable
    fun NavigationGraph(navController: NavHostController) {
        NavHost(navController, startDestination = BottomNavItem.Home.route) {
            composable(BottomNavItem.Home.route) {
                HomeScreen(navController, homeViewModel = homeViewModel)
            }
            composable(BottomNavItem.Events.route) {
                EventsScreen(navController, eventsViewModel = eventsViewModel)
            }
            composable(BottomNavItem.Profile.route) {
                ProfileScreen(navController, profileViewModel = profileViewModel)
            }
            composable(BottomNavItem.Search.route) {
                SearchScreen(navController, searchViewModel = searchViewModel)
            }
        }
    }


    @Composable
    fun MyBottomNavigation(navController: NavController, items: List<BottomNavItem>) {
        BottomNavigation(
            modifier = Modifier
                .clip(RoundedCornerShape(50.dp))
                .border(
                    shape = RoundedCornerShape(50.dp),
                    border = BorderStroke(3.dp, CyanTeal)
                ),
            backgroundColor = Teal500,
            contentColor = Cyan200,
            elevation = 10.dp) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            items.forEach { item ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                            tint = Cyan200
                        )
                    },
                    label = { Text(item.title, fontSize = 12.sp, color = Cyan200) },
                    alwaysShowLabel = true,
                    selected = currentRoute == item.route,
                    onClick = {
                        navController.navigate(item.route) {
                            navController.graph.startDestinationRoute?.let { screen_route ->
                                popUpTo(screen_route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop =
                                true //si el usuario pulsa de manera continua no crea una pila gigante
                            restoreState = true
                        }
                    })
            }
        }
    }
}