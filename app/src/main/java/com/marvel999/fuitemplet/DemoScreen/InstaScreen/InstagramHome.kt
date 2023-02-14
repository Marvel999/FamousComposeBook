package com.marvel999.fuitemplet.DemoScreen.InstaScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.marvel999.fuitemplet.DemoScreen.ui.theme.FUITempletTheme
import com.marvel999.fuitemplet.R

class InstagramHome : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FUITempletTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun BirthdayCardGreetingImage(greet: String) {
    val image = painterResource(id = R.drawable.androidparty)
    Image(
        painter = image,
        contentDescription = null
    )

    Row {
        Text (text = "Name")
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    FUITempletTheme {
        BirthdayCardGreetingImage("Good Morning Android and Happy Birthday")
    }
}