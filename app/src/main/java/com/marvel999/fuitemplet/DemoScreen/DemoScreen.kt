package com.marvel999.fuitemplet.DemoScreen

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marvel999.fuitemplet.DemoScreen.ui.theme.FUITempletTheme
import com.marvel999.fuitemplet.ui.theme.Dimensions

class DemoScreen : ComponentActivity() {
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
fun MyCanvas() {
    Box {
        Canvas(modifier = Modifier
            .width(Dimensions.DP_400.dp)
            .height(Dimensions.DP_400.dp)
            .align(Alignment.Center), onDraw = {
            drawCircle(
                Brush.linearGradient(
                    colors = listOf(
                        Color(android.graphics.Color.parseColor("#180F1E")),
                        Color(android.graphics.Color.parseColor("#9092FF"))
                    )
                ),
                radius = (size.width - (size.width * 0.020f)) / 2,
                center = center,
                style = Stroke(width = size.width * 0.020f)
            )
        })

        Text(
            text = "Hacktoberfest\n2K22",
            modifier = Modifier.align(Alignment.Center),
            color = Color(android.graphics.Color.parseColor("#180F1E")),
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            textAlign = TextAlign.Center,
            fontSize = 50.sp
        )
    }
}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview2() {
    FUITempletTheme {
        MyCanvas()
    }
}