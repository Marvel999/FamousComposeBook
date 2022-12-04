package com.marvel999.fuitemplet.landingscreen.componets

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import com.marvel999.fuitemplet.R
import com.marvel999.fuitemplet.Spotify.ui.theme.offWhiteTextColor
import com.marvel999.fuitemplet.ui.theme.Dimensions
import com.marvel999.fuitemplet.ui.theme.LiteBase0
import com.marvel999.fuitemplet.ui.theme.LiteGray0
import com.marvel999.fuitemplet.ui.theme.LiteTextBase0

@Composable
fun LandingPageListItemCard(landingPageListItemCardData: LandingPageListItemCardData) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = LiteBase0)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(
                    bounded = true,
                    color = Color.Black
                ),
                onClick = {
                    landingPageListItemCardData.onItemClick?.invoke()
                }
            )
            .padding(
                Dp(Dimensions.DP_16),
                Dp(Dimensions.DP_12),
                Dp(Dimensions.DP_12),
                Dp(Dimensions.DP_12)
            )
    ) {
        Row(modifier = Modifier.align(Alignment.CenterStart)) {
            Image(
                painter = painterResource(id = landingPageListItemCardData.appIcon),
                contentDescription = "App Icon",
                modifier = Modifier
                    .width(Dp(Dimensions.DP_40))
                    .height(Dp(Dimensions.DP_40))
                    .clip(
                        CircleShape
                    )
                    .border(
                        Dp(Dimensions.DP_2),
                        landingPageListItemCardData.iconBorderColor,
                        CircleShape
                    )
            )

            Text(
                text = landingPageListItemCardData.appTemplateName,
                fontWeight = FontWeight.SemiBold,
                color = LiteTextBase0,
                fontSize = 14.sp,
                modifier = Modifier.padding(
                    start = Dp(Dimensions.DP_16),
                    top = Dp(Dimensions.DP_11),
                    bottom = Dp(Dimensions.DP_11)
                )
            )
        }

        Icon(
            modifier = Modifier
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(
                        bounded = true,
                        color = Color.Black
                    ),
                    onClick = { landingPageListItemCardData.onItemClick?.invoke() })
                .width(Dp(Dimensions.DP_40))
                .height(Dp(Dimensions.DP_40))
                .padding(Dp(Dimensions.DP_8))
                .align(Alignment.CenterEnd),
            tint = LiteTextBase0,
            painter = painterResource(id = R.drawable.ic_right),
            contentDescription = "Right Icon"
        )
    }
}

@Preview
@Composable
fun LandingPageListItemCardPreview() {
    LandingPageListItemCard(
        LandingPageListItemCardData(
            appTemplateName = "1Screen",
            onItemClick = { LandingPageListItemCardData(appTemplateName = "Me") })
    )
}

data class LandingPageListItemCardData(
    @DrawableRes
    val appIcon: Int = R.drawable.img_landingscreen_default_icon,
    val iconBorderColor: Color = LiteGray0,
    val appTemplateName: String,
    val onItemClick: (() -> Unit)? = null
)