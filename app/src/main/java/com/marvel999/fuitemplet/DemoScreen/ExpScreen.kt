package com.marvel999.fuitemplet.DemoScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.marvel999.fuitemplet.DemoScreen.ui.theme.FUITempletTheme
import com.marvel999.fuitemplet.DemoScreen.ui.theme.instagramTypography
import com.marvel999.fuitemplet.R

class ExpScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FUITempletTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyCanvas()
                }
            }
        }
    }
}

@Composable
fun HomeUI() {
    Column {
        TopAppBar()
        Spacer(modifier = Modifier.height(16.dp))
        UserStoryUI()
        Spacer(modifier = Modifier.height(10.dp))
        UserPostUI()
    }
}

@Composable
fun UserPostUI() {
    Column (modifier = Modifier.padding(start = 10.dp)) {
        PostHeaderUI()
        Spacer(modifier = Modifier.height(10.dp))
        val gojoImage = painterResource(id = R.drawable.gojo_anime)
        Image(painter = gojoImage,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        )
        UserPostInteractionUI()
    }

}

@Composable
fun PostHeaderUI() {
    Row(horizontalArrangement = Arrangement.SpaceBetween,
    modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
    ) {
      Row {
          val userProfile = painterResource(id = R.drawable.model_si)
          Image(
              painter = userProfile,
              contentDescription = null,
              modifier = Modifier
                  .size((28.dp))
                  .clip(CircleShape)
                  .border(
                      width = 2.dp,
                      color = Color("#feda75".toColorInt()),
                      shape = CircleShape
                  ),
              contentScale = ContentScale.Crop
          )
          Text(text = "Westly.windler", style = TextStyle(fontSize = 8.sp),
              modifier = Modifier
                  .align(Alignment.CenterVertically)
                  .padding(start = 4.dp)
          )
      }
        val optionIcon = painterResource(id = R.drawable.ic_baseline_more_horiz_24)
        Image(painter = optionIcon, contentDescription = null)

    }

}

@Composable
fun UserPostInteractionUI() {
    Row (modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row (horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.wrapContentWidth()) {
            val likeIcon = painterResource(id = R.drawable.heart)
            val commentIcon = painterResource(id = R.drawable.chat)
            val shareIcon = painterResource(id = R.drawable.send)

            val iconList = listOf(likeIcon, commentIcon, shareIcon)
            for (icon in iconList) {
                Image(
                    painter = icon,
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .padding(end = 10.dp)
                )
            }
        }

        val bookMarkIcon = painterResource(id = R.drawable.bookmark)
        Image(
            painter = bookMarkIcon,
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .padding(end = 10.dp)

        )
    }

}


@Composable
fun UserStoryUI() {
    Column (modifier = Modifier.wrapContentHeight()) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {

            Text(text = "Stories", modifier = Modifier.padding(start = 10.dp))

            Row {
                val playIcon = painterResource(id = R.drawable.ic_baseline_play_arrow_24)
                Image(painter = playIcon, contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(end = 10.dp)
                )
                Text(text = "Watch all", style = TextStyle(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(end = 10.dp))
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        UserFriendsStoryList()
    }
}

@Composable
fun UserOwnStoryUI() {
    Box(modifier = Modifier.padding(start = 10.dp)) {
        val devImage = painterResource(id = R.drawable.developer)
        val addIcon = painterResource(id = R.drawable.ic_baseline_add_circle_outline_24)
        Image(
            painter = devImage,
            contentDescription = null,
            modifier = Modifier
                .size((68.dp))
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Image (
            painter = addIcon,
            contentDescription = null,
            modifier = Modifier
                .size(16.dp)
                .padding(bottom = 3.dp)
                .align(Alignment.BottomEnd)
        )
    }
}

@Composable
fun UserFriendsStoryList() {

    val list = listOf(R.drawable.model_f, R.drawable.model_s, R.drawable.model_t, R.drawable.model_fo,
    R.drawable.model_fi, R.drawable.model_si)

    LazyRow() {
        item {
            UserOwnStoryUI()
        }

        items(list) { model ->
            Box(modifier = Modifier.padding(start = 10.dp)) {
                Image(
                    painter = painterResource(id = model),
                    contentDescription = null,
                    modifier = Modifier
                        .size((68.dp))
                        .clip(CircleShape)
                        .border(
                            width = 2.dp,
                            color = Color("#feda75".toColorInt()),
                            shape = CircleShape
                        ),
                    contentScale = ContentScale.Crop
                )
            }
        }

    }

}

/**
 * Instagram TopAppBar UI for showing different UI Cases here
 */
@Composable
fun TopAppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.SpaceBetween
    )
    {
        Box(
            modifier = Modifier
                .wrapContentSize(Alignment.Center)
                .padding(start = 10.dp)
        ) {
            Text(
                text = "Instagram",
                style = TextStyle(
                    fontFamily = instagramTypography,
                    fontSize = 32.sp,
                ),
                textAlign = TextAlign.Center
            )
        }
        Row(
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            TopBarCenterImage(res = R.drawable.ic_insta_add_post_icon,
                Modifier.padding(end = 10.dp))
            Spacer(modifier = Modifier.width(10.dp))
            TopBarCenterImage(res = R.drawable.ic_instagram_share_icon,
                Modifier.padding(end = 10.dp))
        }
    }

}

@Composable
fun RowScope.TopBarCenterImage(@DrawableRes res: Int, modifier: Modifier) {
    Image(
        painter = painterResource(id = res),
        contentDescription = null,
        modifier = modifier
            .align(Alignment.CenterVertically)
            .size(24.dp),
        alignment = Alignment.Center

    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DefaultPreview() {
    FUITempletTheme {
        HomeUI()
    }
}