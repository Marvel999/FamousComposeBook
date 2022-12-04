package com.marvel999.fuitemplet.Spotify.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.TextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marvel999.fuitemplet.R
import com.marvel999.fuitemplet.Spotify.component.SearchScreenComponent.SearchGridItem
import com.marvel999.fuitemplet.Spotify.data.getSearchGridList
import com.marvel999.fuitemplet.Spotify.ui.theme.Typography
import com.marvel999.fuitemplet.Spotify.ui.theme.dark
import com.marvel999.fuitemplet.Spotify.ui.theme.tertiary

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SpotifySearchScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(dark)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(dark)
                .padding(bottom = 60.dp)
        ) {
            item {
                Spacer(modifier = Modifier.padding(top = 30.dp))
                Text(
                    "Search",
                    modifier = Modifier
                        .padding(top = 18.dp, start = 15.dp)
                        .weight(2f),
                    color = tertiary,
                    style = Typography.titleMedium,
                    fontSize = 22.sp
                )
            }

            stickyHeader {
                LabelAndPlaceHolder(modifier = Modifier.padding(top = 30.dp))
            }

            item {
                Text(
                    "Browse all",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp, start = 15.dp)
                        .weight(2f),
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    style = Typography.titleMedium,
                    fontSize = 22.sp
                )
            }

            items(getSearchGridList().windowed(2, 2, true)) { subList ->
                Row(modifier = Modifier.padding(top = 10.dp)) {
                    subList.forEach {
                        Spacer(modifier = Modifier.width(10.dp))
                        SearchGridItem(
                            searchGridItemData = it,
                            modifier = Modifier.padding(start = 10.dp)
                        )
                    }
                }
            }

        }
    }
}

@Composable
fun LabelAndPlaceHolder(modifier: Modifier = Modifier) {
    val textState = remember { mutableStateOf(TextFieldValue()) }
    TextField(
        value = textState.value,
        onValueChange = { textState.value = it },
        modifier = Modifier
            .fillMaxWidth()
            .background(dark)
            .padding(horizontal = 20.dp, vertical = 25.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(Color.White),
        placeholder = { PlaceholderText() },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_spotify_search),
                contentDescription = "Leading icon",
                tint = dark,
                modifier = Modifier
                    .width(25.dp)
                    .height(25.dp)
            )
        }

    )
}

@Composable
fun PlaceholderText() {
    Text(
        text = "What do you want to listen to?",
        color = Color.Black,
        style = Typography.bodyMedium,
        fontSize = 16.sp
    )
}

@Preview
@Composable
fun SpotifySearchScreenPreview() {
    SpotifySearchScreen()
}
