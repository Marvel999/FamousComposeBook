package com.marvel999.fuitemplet.Spotify.screen

import android.graphics.Color.parseColor
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marvel999.fuitemplet.R
import com.marvel999.fuitemplet.Spotify.component.LibraryListItem
import com.marvel999.fuitemplet.Spotify.data.getLibraryListData
import com.marvel999.fuitemplet.Spotify.ui.theme.Typography
import com.marvel999.fuitemplet.Spotify.ui.theme.cardGrayBackGround
import com.marvel999.fuitemplet.Spotify.ui.theme.dark
import com.marvel999.fuitemplet.Spotify.utill.randomHexColorGanrator


@Composable
fun SpotifyLibraryScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(dark)
            .padding(bottom = 60.dp)
    ) {
        LibraryHeader(modifier = Modifier.padding(top = 40.dp, start = 10.dp))
        LibraryBodyContent(modifier = Modifier.padding(top = 15.dp))
    }
}

@Composable
fun LibraryHeader(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "M",
                color = dark,
                modifier = Modifier
                    .wrapContentSize()
                    .clip(RoundedCornerShape(70))
                    .background(Color(parseColor(randomHexColorGanrator())))
                    .padding(10.dp),
                style = Typography.titleLarge,
                fontSize = 15.sp
            )

            Text(
                text = "Your Library",
                color = Color.White,
                modifier = Modifier
                    .padding(start = 10.dp),
                style = Typography.titleLarge,
                fontSize = 25.sp
            )
            Spacer(Modifier.weight(1f))
            Icon(
                painter = painterResource(id = R.drawable.ic_spotify_search),
                contentDescription = "Search icon",
                tint = Color.White,
                modifier = Modifier.size(width = 30.dp, height = 30.dp)
            )
            Spacer(Modifier.width(15.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_spotify_add),
                contentDescription = "Add icon",
                tint = Color.White,
                modifier = Modifier.size(width = 30.dp, height = 30.dp)
            )
            Spacer(Modifier.width(5.dp))
        }
        RowTopic(modifier = Modifier.padding(top = 20.dp))
        Spacer(
            Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(Color.Black)
        )
    }
}

@Composable
fun LibraryBodyContent(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.fillMaxWidth()) {
        item {
            Row {
                Icon(
                    painter = painterResource(id = R.drawable.ic_spotify_cross_arrow),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(25.dp).padding(start = 10.dp)
                )
                Text(
                    text = "Most recent",
                    color = Color.White,
                    modifier = Modifier
                        .padding(start = 10.dp),
                    style = Typography.bodyMedium,
                    fontSize = 12.sp
                )
            }
        }

        itemsIndexed(getLibraryListData()) { index, item ->
            LibraryListItem(libraryListItemData = item)
        }

        item {
            Row(modifier.padding(horizontal = 15.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_spotify_add),
                    contentDescription = null,
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape)
                        .background(cardGrayBackGround)
                        .padding(15.dp)
                )

                Column(modifier = Modifier.padding(vertical = 25.dp)) {
                    Text(
                        "Add artists",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp),
                        color = Color.White,
                        style = Typography.bodySmall,
                        fontSize = 16.sp
                    )
                }
            }
        }

        item {
            Row(modifier.padding(horizontal = 15.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_spotify_add),
                    contentDescription = null,
                    modifier = Modifier
                        .size(70.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(cardGrayBackGround)
                        .padding(15.dp)
                )

                Column(modifier = Modifier.padding(vertical = 25.dp)) {
                    Text(
                        "Add Podcasts & shows",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp),
                        color = Color.White,
                        style = Typography.bodySmall,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun SpotifyLibraryScreenPreview() {
    SpotifyLibraryScreen()

}