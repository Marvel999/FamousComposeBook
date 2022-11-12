package com.marvel999.fuitemplet.DemoScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
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
import androidx.compose.ui.graphics.Brush
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
import com.marvel999.fuitemplet.DemoScreen.ui.theme.instagramTextTypography
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
        UserFriendsStoryList()
        Spacer(modifier = Modifier.height(10.dp))
        UserPostUI()
    }
}

@Composable
fun UserPostUI() {
    Column {
        PostHeaderUI()
        Spacer(modifier = Modifier.height(10.dp))
        val gojoImage = painterResource(id = R.drawable.sportsscene)
        Image(
            painter = gojoImage,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .defaultMinSize(minHeight = 330.dp)
                .background(Color("#F1F3F4".toColorInt()))
            ,
        )
        UserPostInteractionUI()
        Spacer(modifier = Modifier.height(10.dp))
        UserPostDescription()
    }

}

@Composable
fun PostHeaderUI() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(start = 10.dp, end = 10.dp)
    ) {
      Row {
          val userProfile = painterResource(id = R.drawable.model_si)
          Image(
              painter = userProfile,
              contentDescription = null,
              modifier = Modifier
                  .size((40.dp))
                  .clip(CircleShape)
                  .border(
                      width = 2.dp,
                      color = Color("#feda75".toColorInt()),
                      shape = CircleShape
                  ),
              contentScale = ContentScale.Crop
          )
          Text(text = "Westly.windler",
              style = TextStyle(
                  fontSize = 14.sp,
                  fontWeight = FontWeight.Bold
              ),
              modifier = Modifier
                  .align(Alignment.CenterVertically)
                  .padding(start = 8.dp)
          )
      }
        val optionIcon = painterResource(id = R.drawable.ic_baseline_more_horiz_24)
        Image(painter = optionIcon, contentDescription = null)

    }

}

@Composable
fun UserOwnStoryUI() {
    Column(modifier = Modifier.padding(start = 10.dp)) {

        Box {
            val devImage = painterResource(id = R.drawable.developer)
            val addIcon = painterResource(id = R.drawable.ic_insta_add_story)

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
                    .size(24.dp)
                    .align(Alignment.BottomEnd)
            )
        }

        Text(
            text = "Your story",
            style = TextStyle(
                fontFamily = instagramTextTypography,
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            ),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 6.dp)
        )
    }
}

@Composable
fun UserFriendsStoryList() {

    val userStoryList = listOf(
        UserStories(R.drawable.model_f, "Keni Zami"),
        UserStories(R.drawable.model_s, "lizyzoe"),
        UserStories(R.drawable.model_t, "lofit112"),
        UserStories(R.drawable.model_fo, "kendo fam"),
        UserStories(R.drawable.model_fi, "nataliya"),
        UserStories(R.drawable.model_si, "niroma khan"),
    )
    val circleColors: List<Color> = listOf(
        Color(0xFF833AB4),
        Color(0xFFC13584),
        Color(0xFFE1306C),
        Color(0xFFFD1D1D),
        Color(0xFFF56040),
        Color(0xFFF77737),
        Color(0xFFFCAF45),
        Color(0xFFFFDC80),
    )

    LazyRow() {
        item {
            UserOwnStoryUI()
        }

        items(userStoryList) { model ->
            Column (modifier = Modifier.padding(start = 10.dp))  {
                Image(
                    painter = painterResource(id = model.userImage),
                    contentDescription = null,
                    modifier = Modifier
                        .size((68.dp))
                        .border(
                            width = 2.dp,
                            brush = Brush.sweepGradient(circleColors),
                            shape = CircleShape
                        )
                        .padding(all = 6.dp)
                        .clip(CircleShape)
                    ,
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = model.userName,
                    style = TextStyle(
                         fontFamily = instagramTextTypography,
                        fontSize = 10.sp
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 6.dp)
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

/**
 * Post Liked, Dates, Comments Of the users
 */

@Composable
fun PostLikedUI() {

    Row(modifier = Modifier) {
        Image(
            painter = painterResource(id = R.drawable.model_f),
            contentDescription = null,
            modifier = Modifier
                .size(34.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .offset((-10).dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.model_si),
                contentDescription = null,
                modifier = Modifier
                    .size(34.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        }
    }

}

@Composable
fun UserPostInteractionUI() {
    Spacer(modifier = Modifier.height(10.dp))
    Row (modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(start = 10.dp, end = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row (horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.wrapContentWidth()) {
            val likeIcon = painterResource(id = R.drawable.ic_insta_like_icon)
            val commentIcon = painterResource(id = R.drawable.ic_insta_comment_icon)
            val shareIcon = painterResource(id = R.drawable.ic_instagram_share_icon)

            val iconList = listOf(likeIcon, commentIcon, shareIcon)
            for (icon in iconList) {
                Image(
                    painter = icon,
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .padding(end = 15.dp)
                        .align(Alignment.CenterVertically)
                )
            }
        }

        val bookMarkIcon = painterResource(id = R.drawable.ic_baseline_bookmark_border_24)
        Image(
            painter = bookMarkIcon,
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .padding(end = 10.dp)

        )
    }

}

@Composable
fun UserPostDescription() {
    Column (modifier = Modifier.padding(start = 10.dp, end = 10.dp)) {
        Text(
            text = "47 Likes",
            style = TextStyle(
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text (
            messageFormatter(comment = "Today evening is so good #GoodEvening #CrazyNight"),
            style = TextStyle(fontSize = 12.sp),
            maxLines = 1
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = "1 hour ago",
            style = TextStyle(
                fontWeight = FontWeight.Light,
                fontSize = 10.sp,
                color = Color.LightGray
            )
        )
    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DefaultPreview() {
    FUITempletTheme {
        HomeUI()
    }
}

data class UserStories(@DrawableRes val userImage: Int, val userName: String)