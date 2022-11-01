package com.marvel999.fuitemplet.DemoScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marvel999.fuitemplet.DemoScreen.ui.theme.FUITempletTheme
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



}


@Composable
fun UserStoryUI() {
    Column (modifier = Modifier.wrapContentHeight()) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().wrapContentHeight()
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
            .wrapContentHeight()
    )
    {
        TopBarCenterImage(res = R.drawable.ic_baseline_camera_alt, Modifier.padding(start = 10.dp))
        Box(
            modifier = Modifier
                .wrapContentSize(Alignment.Center)
                .weight(1f)
        ) {
            Text(
                text = "Instagram",
                style = TextStyle(
                    fontFamily = FontFamily.Cursive,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold,
                    fontStyle = FontStyle.Italic
                ),
                textAlign = TextAlign.Center
            )
        }
        TopBarCenterImage(res = R.drawable.ic_baseline_send_24, Modifier.padding(end = 10.dp))
    }

}

@Composable
fun RowScope.TopBarCenterImage(@DrawableRes res: Int, modifier: Modifier) {
    Image(
        painter = painterResource(id = res),
        contentDescription = null,
        modifier = modifier.align(Alignment.CenterVertically)
    )
}

@Preview
@Composable
fun DefaultPreview() {
    FUITempletTheme {
        UserStoryUI()
    }
}