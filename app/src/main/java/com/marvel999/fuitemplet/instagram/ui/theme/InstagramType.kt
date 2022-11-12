package com.marvel999.fuitemplet.instagram.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.marvel999.fuitemplet.R


// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

val instagramTypography = FontFamily(Font(R.font.root_insta))

val instagramTextTypography = FontFamily(
    Font(R.font.instagram_sans_regular, FontWeight.Normal),
    Font(R.font.instagram_sans_medium, FontWeight.Medium),
    Font(R.font.instagram_sans_light, FontWeight.Light)
)