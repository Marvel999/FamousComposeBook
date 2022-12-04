package com.marvel999.fuitemplet.Spotify.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marvel999.fuitemplet.R
import com.marvel999.fuitemplet.Spotify.ui.theme.SpotifyTheme
import com.marvel999.fuitemplet.Spotify.ui.theme.Typography
import com.marvel999.fuitemplet.Spotify.ui.theme.cardGrayBackGround
import com.marvel999.fuitemplet.Spotify.ui.theme.dark

@Composable
fun MusicGridComposeItem(musicGridData: MusicGridData, modifier: Modifier = Modifier) {
    Row(
        modifier
            .wrapContentHeight()
            .clip(RoundedCornerShape(8.dp))
            .background(cardGrayBackGround)
            .width(175.dp)
            .clickable(onClick = {})
            .padding(end = 4.dp)
    ) {
        Image(
            painter = painterResource(id = musicGridData.ImageRes),
            contentDescription = null,
            modifier = Modifier
                .size(width = 60.dp, height = 60.dp)
                .clip(
                    RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp)
                )
        )
        Text(
            text = musicGridData.songName,
            modifier = Modifier
                .wrapContentSize()
                .padding(start = 12.dp, end = 16.dp)
                .align(Alignment.CenterVertically),
            color = Color.White,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = Typography.titleMedium
        )
    }
}

data class MusicGridData(val songName: String, @DrawableRes val ImageRes: Int)

@Preview
@Composable
fun MusicGridComposeItemPreview() {
    SpotifyTheme {
        MusicGridComposeItem(MusicGridData("Bollywood", R.drawable.ic_hacktober_icon))
    }
}