package com.marvel999.fuitemplet.Spotify

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
import com.marvel999.fuitemplet.Spotify.component.MusicGridComposeItem
import com.marvel999.fuitemplet.Spotify.component.RowMusicData
import com.marvel999.fuitemplet.Spotify.component.RowMusicItem
import com.marvel999.fuitemplet.Spotify.data.getMusicGridData
import com.marvel999.fuitemplet.Spotify.data.getMusicRowData
import com.marvel999.fuitemplet.Spotify.ui.theme.*
import java.util.*
import kotlin.random.Random.Default.nextInt

class SpotifyHomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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
            SearchScreen()
        }
        composable(BottomNavItem.Library.screen_route) {
            LibraryScreen()
        }
        composable(BottomNavItem.Premium.screen_route) {
            PremiumScreen()
        }
    }
}

@Composable
fun SearchScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_700))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "My Search Screen",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
    }
}

@Composable
fun LibraryScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_700))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Add Library Screen",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
    }
}


@Composable
fun PremiumScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_700))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Premium Screen",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SpotifyHomeScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(dark)
            .padding(start = 16.dp)
    ) {
        item {
            SpotifyHeader(modifier = Modifier.padding(top = 15.dp))
        }
        stickyHeader {
            RowTopic()
            Spacer(modifier = Modifier.padding(top = 20.dp))
        }
        items(getMusicGridData().windowed(2, 2, true)) { subList ->
            Row(modifier = Modifier.padding(top = 10.dp)) {
                subList.forEach {
                    MusicGridComposeItem(musicGridData = it)
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }
        }

        items(4) {
            SpotifySongRow(sectionName = "Artists for you", list = getMusicRowData())
        }
    }
}

@Composable
fun SpotifySongRow(sectionName: String, list: List<RowMusicData>, modifier: Modifier = Modifier) {
    Column {
        Spacer(modifier = modifier.height(20.dp))
        Text(
            text = sectionName,
            modifier = modifier
                .padding(top = 18.dp),
            color = Color.White,
            style = Typography.titleMedium,
            fontSize = 24.sp
        )
        Spacer(modifier = modifier.height(12.dp))
        LazyRow {
            itemsIndexed(list) { index: Int, item: RowMusicData ->
                RowMusicItem(rowMusicData = item, modifier.padding(end = 20.dp))
            }
        }

    }

}

@Composable
fun RowTopic() {
    val mutableList = listOf("Music", "Podcasts & Shows", "Song", "Playlist", "Audio Book")
    LazyRow(
        Modifier
            .background(dark)
            .padding(top = 8.dp, bottom = 8.dp)
    ) {
        itemsIndexed(mutableList) { index, item ->
            Text(
                text = item,
                modifier = Modifier
                    .wrapContentSize()
                    .fillMaxWidth(0.3f)
                    .clip(CircleShape)
                    .background(cardGrayBackGround)
                    .padding(top = 8.dp, bottom = 8.dp, end = 20.dp, start = 20.dp),
                color = Color.White,
                style = Typography.bodySmall,
            )
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}

@Composable
fun SpotifyHeader(modifier: Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            "Good Morning :)",
            modifier = Modifier
                .padding(top = 18.dp)
                .weight(2f),
            color = tertiary,
            style = Typography.titleMedium,
            fontSize = 22.sp
        )
        IconsComposable(
            modifier = Modifier
                .weight(1f)
                .padding(end = 16.dp)
        )
    }
}

@Composable
fun IconsComposable(modifier: Modifier) {
    Row(modifier = modifier.wrapContentSize()) {
        val modifierIcon = Modifier
            .padding(top = 15.dp, bottom = 15.dp)
            .size(width = 40.dp, height = 40.dp)
            .padding(start = 4.dp, end = 4.dp)

        Icon(
            painter = painterResource(id = R.drawable.ic_spotify_notification),
            modifier = modifierIcon,
            tint = Color.White,
            contentDescription = null
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_spotify_history),
            modifier = modifierIcon,
            tint = Color.White,
            contentDescription = null
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_spotify_setting),
            modifier = modifierIcon,
            tint = Color.White,
            contentDescription = null
        )
    }
}

@Preview
@Composable
fun SpotifyPreview() {
    SpotifyTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(dark)
        ) {
            SpotifyHomeScreen()
        }
    }
}