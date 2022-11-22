package com.marvel999.fuitemplet.Spotify.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marvel999.fuitemplet.R
import androidx.constraintlayout.compose.ConstraintLayout
import com.marvel999.fuitemplet.Spotify.ui.theme.Typography
import com.marvel999.fuitemplet.Spotify.ui.theme.offWhiteTextColor
import com.marvel999.fuitemplet.Spotify.ui.theme.playerCardGrayBackGround

@Composable
fun SpotifyFloatingPlayer() {
    ConstraintLayout(
        modifier = Modifier
            .width(355.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(playerCardGrayBackGround)
            .height(60.dp)
            .clickable(onClick = {})
    ) {
        val (image, songNameText, singerNameText, progressBar, iconGroup) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.img_spotify_song_1),
            contentDescription = null,
            modifier = Modifier
                .size(height = 40.dp, width = 45.dp)
                .padding(start = 10.dp)
                .clip(RoundedCornerShape(4.dp))
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                },
            contentScale = ContentScale.FillBounds
        )

        Text(
            text = "TedTalk : Mati ka sathi",
            modifier = Modifier
                .defaultMinSize(minHeight = 15.dp, minWidth = 195.dp)
                .padding(start = 8.dp)
                .constrainAs(songNameText) {
                    top.linkTo(image.top)
                    start.linkTo(image.end)
                },
            color = Color.White,
            style = Typography.bodyMedium,
            maxLines = 2,
            textAlign = TextAlign.Justify,
            overflow = TextOverflow.Ellipsis,
            fontSize = 12.sp,
        )

        Text(
            text = "Vishal Dadlani",
            modifier = Modifier
                .padding(start = 8.dp, top = 2.dp)
                .constrainAs(singerNameText) {
                    top.linkTo(songNameText.bottom)
                    start.linkTo(image.end)
                },
            color = offWhiteTextColor,
            style = Typography.displaySmall,
            maxLines = 2,
            textAlign = TextAlign.Justify,
            overflow = TextOverflow.Ellipsis,
            fontSize = 12.sp,
        )

        IconGroup(modifier = Modifier.constrainAs(iconGroup) {
            top.linkTo(parent.top)
            start.linkTo(songNameText.end)
            bottom.linkTo(parent.bottom)
        })

        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .padding(start = 4.dp, end = 4.dp)
                .constrainAs(progressBar) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
            progress = 0.6f,
            backgroundColor = Color.Gray,
            color = Color.White,
        )
    }
}


@Composable
fun IconGroup(modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        Icon(
            painter = painterResource(id = R.drawable.ic_spotify_computer),
            contentDescription = null,
            tint = offWhiteTextColor,
            modifier = Modifier
                .width(35.dp)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(bounded = false, color = offWhiteTextColor), // You can also change the color and radius of the ripple
                    onClick = {}
                )
                .padding(5.dp),
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_spotify_like),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .width(35.dp)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(bounded = false, color = offWhiteTextColor), // You can also change the color and radius of the ripple
                    onClick = {}
                )
                .padding(5.dp),
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_spotify_play),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .width(35.dp)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(bounded = false, color = offWhiteTextColor), // You can also change the color and radius of the ripple
                    onClick = {}
                )
                .padding(5.dp),
        )
    }
}

@Preview
@Composable
fun SpotifyFloatingPlayerPreview() {
    SpotifyFloatingPlayer()
}