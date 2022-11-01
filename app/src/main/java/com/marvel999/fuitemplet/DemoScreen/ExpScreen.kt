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
import androidx.compose.ui.tooling.preview.Preview
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
fun TopAppBar() {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.Top
    )
    {
        TopBarCenterImage(res = R.drawable.ic_baseline_camera_alt, Alignment.CenterStart)
        InstagramText()
        TopBarCenterImage(res = R.drawable.ic_baseline_send_24, Alignment.CenterEnd)
    }

}

@Composable
fun RowScope.TopBarCenterImage(@DrawableRes res: Int, alignment: Alignment) {
    Image(
        painter = painterResource(id = res),
        contentDescription = null,
        modifier = Modifier.align(Alignment.CenterVertically),
        alignment = alignment
    )
}


@Composable
fun InstagramText() {
    Text(
        text = "Instagram",
        style = TextStyle(
            fontFamily = FontFamily.Cursive,
            fontSize = 32.sp,
            fontWeight = FontWeight.ExtraBold,
            fontStyle = FontStyle.Italic
        )
    )
}

@Preview
@Composable
fun DefaultPreview() {
    FUITempletTheme {
        TopAppBar()
    }
}