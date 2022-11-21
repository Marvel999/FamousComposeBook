package com.marvel999.fuitemplet.Spotify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.marvel999.fuitemplet.R
import com.marvel999.fuitemplet.Spotify.component.SpotifyFloatingPlayer
import com.marvel999.fuitemplet.Spotify.screen.SpotifyHomeScreen
import com.marvel999.fuitemplet.Spotify.screen.SpotifyLibraryScreen
import com.marvel999.fuitemplet.Spotify.screen.SpotifyPremiumScreen
import com.marvel999.fuitemplet.Spotify.screen.SpotifySearchScreen
import com.marvel999.fuitemplet.Spotify.ui.theme.*

class SpotifyHomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpotifyTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(dark)
                ) {
                    val navController = rememberNavController()
                    Scaffold(
                        bottomBar = { BottomNavigation(navController = navController) },
                        floatingActionButton = { SpotifyFloatingPlayer()}
                    ) {
                        NavigationGraph(navController = navController)
                    }
                }
            }
        }
    }
}

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Search,
        BottomNavItem.Library,
        BottomNavItem.Premium,
    )
    androidx.compose.material.BottomNavigation(
        backgroundColor = Color.Black,
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(id = item.icon),
                        contentDescription = item.title,
                        modifier = Modifier.size(25.dp),
                        tint = offWhiteTextColor
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 12.sp,
                        color = offWhiteTextColor
                    )
                },
                selectedContentColor = Color.White,
                unselectedContentColor = offWhiteTextColor,
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

sealed class BottomNavItem(var title: String, var icon: Int, var screen_route: String) {
    object Home : BottomNavItem("Home", R.drawable.ic_spotify_home, "Home")
    object Search : BottomNavItem("Search", R.drawable.ic_spotify_search, "Search")
    object Library : BottomNavItem("Library", R.drawable.ic_spotify_library, "Library")
    object Premium : BottomNavItem("Premium", R.drawable.ic_spotify_logo, "Premium")
}


@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Home.screen_route) {
        composable(BottomNavItem.Home.screen_route) {
            SpotifyHomeScreen()
        }
        composable(BottomNavItem.Search.screen_route) {
            SpotifySearchScreen()
        }
        composable(BottomNavItem.Library.screen_route) {
            SpotifyLibraryScreen()
        }
        composable(BottomNavItem.Premium.screen_route) {
            SpotifyPremiumScreen()
        }
    }
}

@Preview
@Composable
fun SpotifyPreview() {
    val navController = rememberNavController()
    SpotifyTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(dark)
        ) {
            Scaffold(
                bottomBar = { BottomNavigation(navController = navController) },
            ) {

                NavigationGraph(navController = navController)
            }
        }
    }
}