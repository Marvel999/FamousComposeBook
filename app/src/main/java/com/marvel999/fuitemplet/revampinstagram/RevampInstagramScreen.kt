package com.marvel999.fuitemplet.revampinstagram

import androidx.annotation.DrawableRes
import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.rememberPagerState
import com.marvel999.fuitemplet.R
import com.marvel999.fuitemplet.ui.theme.FUITempletTheme


@OptIn(ExperimentalPagerApi::class)
@Composable
fun ShowViewPager() {
    val list = listOf(
        R.drawable.neon_big,
        R.drawable.neon_man,
        R.drawable.neon_man,
        R.drawable.neon_man,
        R.drawable.neon_man,
    )

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy((-32).dp),
        modifier = Modifier.padding(top = 30.dp)
    ) {
        items(count = list.size) { it ->
            
            Image(painter = painterResource(list[it]),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .clip(RoundedCornerShape(30.dp)),
                contentDescription = null,
                contentScale = ContentScale.FillHeight
            )
        }

    }

}

@Composable
fun ShowBlurBackground() {

    Row {
        val heart = painterResource(id = R.drawable.heartbroken)
        Image(painter = heart, contentDescription = null,
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .blur(20.dp)
        )
    }

}

@Composable
fun ShowAnimationOfHeart() {
    var visible by remember { mutableStateOf(true) }
    val density = LocalDensity.current
    AnimatedVisibility(
        visible = visible,
        enter = slideInVertically {
            // Slide in from 40 dp from the top.
            with(density) { -40.dp.roundToPx() }
        } + expandVertically(
            // Expand from the top.
            expandFrom = Alignment.Top
        ) + fadeIn(
            // Fade in with the initial alpha of 0.3f.
            initialAlpha = 0.3f
        ),
        exit = slideOutVertically() + fadeOut()
    ) {
        Text("Hello",
            Modifier
                .fillMaxWidth()
                .height(200.dp))
    }
}

@Preview (showSystemUi = true)
@Composable
fun ShowPreview() {
    FUITempletTheme {
        ShowBlurBackground()
    }
}