package com.marvel999.fuitemplet.Spotify.component

import android.graphics.Color.parseColor
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marvel999.fuitemplet.R
import com.marvel999.fuitemplet.Spotify.ui.theme.*
import com.marvel999.fuitemplet.Spotify.utill.randomHexColorGanrator

@Composable
fun RowMusicItem(rowMusicData: RowMusicData, modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .width(150.dp)
        .clip(RoundedCornerShape(4.dp))
        .clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = rememberRipple(bounded = true, color = offWhiteTextColor), // You can also change the color and radius of the ripple
            onClick = {}
        )
        .padding(vertical = 15.dp, horizontal = 10.dp)
    ) {
        Box {
            Image(
                painter = painterResource(id = rowMusicData.imageSrc),
                contentDescription = null,
                modifier = Modifier.size(width = 150.dp, height = 135.dp),
                contentScale = ContentScale.FillBounds
            )
            if (rowMusicData.imageDecoratorEnable) {
                Text(
                    rowMusicData.singerName,
                    modifier = Modifier
                        .padding(start = 16.dp, bottom = 20.dp)
                        .align(Alignment.BottomStart),
                    color = tertiary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = Typography.titleLarge,
                    fontSize = 22.sp
                )
                val color = Color(parseColor(randomHexColorGanrator()))
                Spacer(
                    modifier = Modifier
                        .padding(bottom = 25.dp)
                        .background(color)
                        .size(width = 5.dp, height = 20.dp)
                        .align(Alignment.BottomStart)
                )
                Spacer(
                    modifier = Modifier
                        .background(color)
                        .size(width = 150.dp, height = 5.dp)
                        .align(Alignment.BottomStart)
                )
            }
        }

        Text(
            text = rowMusicData.songName,
            modifier = Modifier
                .padding(start = 8.dp, end = 5.dp, top = 5.dp),
            color = offWhiteTextColor,
            style = Typography.bodyMedium,
            maxLines = 2,
            textAlign = TextAlign.Justify,
            overflow = TextOverflow.Ellipsis,
            fontSize = 14.sp,
        )
    }
}

data class RowMusicData(
    val songName: String,
    val singerName: String,
    @DrawableRes val imageSrc: Int,
    val imageDecoratorEnable: Boolean = false
)


@Preview
@Composable
fun RowMusicItemPreview() {
    SpotifyTheme {
        RowMusicItem(
            rowMusicData = RowMusicData(
                "Enemy - From the series Arcane League of Legends fdsfn",
                "Arjit Mix",
                R.drawable.img_spotify_music_grid_1
            )
        )
    }
}