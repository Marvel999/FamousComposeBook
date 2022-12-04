package com.marvel999.fuitemplet.Spotify.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marvel999.fuitemplet.R
import com.marvel999.fuitemplet.Spotify.ui.theme.Typography
import com.marvel999.fuitemplet.Spotify.ui.theme.offWhiteTextColor

@Composable
fun LibraryListItem(libraryListItemData: LibraryListItemData, modifier: Modifier = Modifier) {
    Row(modifier.padding(horizontal = 15.dp)) {
        Image(
            painter = painterResource(id = libraryListItemData.imageRes),
            contentDescription = null,
            modifier = Modifier
                .size(70.dp)
                .clip(
                    CircleShape
                ),
            contentScale = ContentScale.FillBounds
        )

        Column(modifier = Modifier.padding(vertical = 15.dp)) {
            Text(
                libraryListItemData.topic,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp),
                color = Color.White,
                style = Typography.bodySmall,
                fontSize = 16.sp
            )

            Text(
                libraryListItemData.subText,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 4.dp),
                color = offWhiteTextColor,
                style = Typography.bodySmall,
                fontSize = 12.sp
            )
        }
    }
}

data class LibraryListItemData(
    val topic: String,
    val subText: String,
    @DrawableRes val imageRes: Int
)

@Preview
@Composable
fun LibraryListItemPreview() {
    LibraryListItem(
        libraryListItemData = LibraryListItemData(
            "Manish",
            "My Song",
            imageRes = R.drawable.img_spotify_song_1
        )
    )
}