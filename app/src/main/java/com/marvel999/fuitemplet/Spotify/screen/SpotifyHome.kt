package com.marvel999.fuitemplet.Spotify.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marvel999.fuitemplet.R
import com.marvel999.fuitemplet.Spotify.component.MusicGridComposeItem
import com.marvel999.fuitemplet.Spotify.component.RowMusicData
import com.marvel999.fuitemplet.Spotify.component.RowMusicItem
import com.marvel999.fuitemplet.Spotify.data.getMusicGridData
import com.marvel999.fuitemplet.Spotify.data.getMusicRowData
import com.marvel999.fuitemplet.Spotify.data.getTodaysBiggestHitData
import com.marvel999.fuitemplet.Spotify.ui.theme.*

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SpotifyHomeScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(dark)
            .padding(start = 16.dp, bottom = 60.dp)
    ) {
        item {
            SpotifyHeader(modifier = Modifier.padding(top = 15.dp))
        }
        stickyHeader {
            RowTopic()
            Spacer(modifier = Modifier.height(20.dp))
        }
        items(getMusicGridData().windowed(2, 2, true)) { subList ->
            Row(modifier = Modifier.padding(top = 10.dp)) {
                subList.forEach {
                    MusicGridComposeItem(musicGridData = it)
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }
        }

        item{
            SpotifySongRow(sectionName = "Artists for you", list = getMusicRowData())
        }

        item {
            SpotifySongRow(sectionName = "Today's biggest hits", list = getTodaysBiggestHitData())
        }

        item {
            SpotifySongRow(sectionName = "Recently played", list = getTodaysBiggestHitData().shuffled())
        }

        item {
            SpotifySongRow(sectionName = "Spotify original & exclusive shows", list = getTodaysBiggestHitData().shuffled())
        }

        item {
            SpotifySongRow(sectionName = "Made For you", list = getMusicRowData().shuffled())
        }

        item {
            SpotifySongRow(sectionName = "India's Best", list = getTodaysBiggestHitData().shuffled())
        }

        item {
            SpotifySongRow(sectionName = "Trending now", list = getTodaysBiggestHitData().shuffled())
        }

        item {
            SpotifySongRow(sectionName = "Popular albums", list = getTodaysBiggestHitData().shuffled())
        }

        item {
            SpotifySongRow(sectionName = "Based on your recent listening", list = getMusicRowData().shuffled())
        }

        item {
            SpotifySongRow(sectionName = "Your top mixes", list = getTodaysBiggestHitData().shuffled())
        }

        item {
            Spacer(modifier = Modifier.width(50.dp))
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
                RowMusicItem(rowMusicData = item )
            }
        }

    }

}

@Composable
fun RowTopic(modifier: Modifier = Modifier) {
    val mutableList = listOf("Music", "Podcasts & Shows", "Song", "Playlist", "Audio Book")
    LazyRow(
        modifier
            .background(dark)
            .padding(top = 12.dp, bottom = 15.dp)
    ) {
        itemsIndexed(mutableList) { index, item ->
            Text(
                text = item,
                modifier = Modifier
                    .wrapContentSize()
                    .fillMaxWidth(0.3f)
                    .clip(CircleShape)
                    .background(cardGrayBackGround)
                    .clickable(onClick = {})
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
            "Good Morning",
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
            modifier = modifierIcon
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(bounded = false, color = offWhiteTextColor), // You can also change the color and radius of the ripple
                    onClick = {}
                ),
            tint = Color.White,
            contentDescription = null
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_spotify_history),
            modifier = modifierIcon .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(bounded = false, color = offWhiteTextColor), // You can also change the color and radius of the ripple
                onClick = {}
            ),
            tint = Color.White,
            contentDescription = null
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_spotify_setting),
            modifier = modifierIcon.clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(bounded = false, color = offWhiteTextColor), // You can also change the color and radius of the ripple
                onClick = {}
            ),
            tint = Color.White,
            contentDescription = null
        )
    }
}