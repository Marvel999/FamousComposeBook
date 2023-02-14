package com.marvel999.fuitemplet.Spotify.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.marvel999.fuitemplet.Spotify.ui.theme.dark

@Composable
fun SpotifyPremiumScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(dark)
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Premium Screen Coming Soon...",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
    }
}