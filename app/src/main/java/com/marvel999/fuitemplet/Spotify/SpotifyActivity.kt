package com.marvel999.fuitemplet.Spotify

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.marvel999.fuitemplet.R
import com.marvel999.fuitemplet.Spotify.ui.theme.*

class SpotifyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpotifyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    val systemUiController: SystemUiController = rememberSystemUiController()
                    systemUiController.isStatusBarVisible = false // Status bar
                    systemUiController.isNavigationBarVisible = false // Navigation bar
                    systemUiController.isSystemBarsVisible = false // Status & Navigation bars
                    AppLogoWithText()
                    Handler().postDelayed({
                        kotlin.run {
                            startActivity(
                                Intent(
                                    this@SpotifyActivity,
                                    SpotifyHomeActivity::class.java
                                )
                            )
                            finish()
                        }
                    }, 1000)
                }
            }
        }
    }
}

@Composable
fun AppLogoWithText() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(dark)) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.Center)
        ) {
            Image(
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.CenterHorizontally),
                painter = painterResource(id = R.drawable.ic_spotify_logo),
                contentDescription = "spotify Splash screen"
            )
            Text(
                "Spotify",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 18.dp),
                color = tertiary,
                style = Typography.titleLarge,
                fontSize = 38.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SpotifyTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = dark
        ) {
            val systemUiController: SystemUiController = rememberSystemUiController()
            systemUiController.isStatusBarVisible = false // Status bar
            systemUiController.isNavigationBarVisible = false // Navigation bar
            systemUiController.isSystemBarsVisible = false // Status & Navigation bars
            AppLogoWithText()
        }
    }
}