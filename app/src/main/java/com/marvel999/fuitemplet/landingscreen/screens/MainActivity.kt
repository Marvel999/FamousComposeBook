package com.marvel999.fuitemplet.landingscreen.screens

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.marvel999.fuitemplet.DemoScreen.DemoScreen
import com.marvel999.fuitemplet.R
import com.marvel999.fuitemplet.landingscreen.componets.LandingPageListItemCard
import com.marvel999.fuitemplet.landingscreen.componets.LandingPageListItemCardData
import com.marvel999.fuitemplet.landingscreen.data.landingPageListItemCardDataList
import com.marvel999.fuitemplet.ui.theme.Dimensions
import com.marvel999.fuitemplet.ui.theme.FUITempletTheme
import com.marvel999.fuitemplet.ui.theme.LiteGray0

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FUITempletTheme() {
                val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
                HomeCompose(scaffoldState = scaffoldState)
            }
        }
    }

    fun StartDemoActivity() {
        startActivity(Intent(this, DemoScreen::class.java))
    }

    @Composable
    fun HomeCompose(scaffoldState: ScaffoldState) {
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = { MyTopAppBar() },
            content = { BodyComposable() },
            contentColor = LiteGray0
        )
    }


    @Composable
    fun MyTopAppBar() {
        TopAppBar(
            title = {
                Text(
                    text = "Clone UI Template",
                    color = Color.White,
                    modifier = Modifier.padding(start = Dp(Dimensions.SPACING_10))
                )
            },
        )
    }


    @Composable
    fun BodyComposable() {
        landingPageListItemCardDataList =
            landingPageListItemCardDataList + LandingPageListItemCardData(
                appIcon = R.drawable.ic_hacktober_icon,
                appTemplateName = "Welcome Screen",
                onItemClick = {
                    StartDemoActivity()
                })
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(LiteGray0)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
            ) {
                // Top lazyList Section
                TopListSection(landingPageListItemCardDataList)

            }
        }
    }

    @Composable
    fun TopListSection(itemList: List<LandingPageListItemCardData>) {
        Column {
            LazyColumn {
                itemsIndexed(itemList) { _, item ->
                    LandingPageListItemCard(landingPageListItemCardData = item)
                }
            }

        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
    }
}