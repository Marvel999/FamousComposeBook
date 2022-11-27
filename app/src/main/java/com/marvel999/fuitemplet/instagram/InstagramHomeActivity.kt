package com.marvel999.fuitemplet.instagram

import android.app.Activity
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.activity.compose.setContent
import androidx.core.view.ViewCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.marvel999.fuitemplet.DemoScreen.HomeUI
import com.marvel999.fuitemplet.R
import com.marvel999.fuitemplet.instagram.ui.theme.InstagramTemplateTheme

class InstagramHomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        setContent {
            InstagramTemplateTheme {
                HomeUI()
            }
        }
    }
}