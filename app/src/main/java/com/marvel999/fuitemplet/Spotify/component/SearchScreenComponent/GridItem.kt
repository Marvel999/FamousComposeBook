package com.marvel999.fuitemplet.Spotify.component.SearchScreenComponent

import android.graphics.Color.parseColor
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.marvel999.fuitemplet.R
import com.marvel999.fuitemplet.Spotify.ui.theme.Typography
import com.marvel999.fuitemplet.Spotify.utill.randomHexColorGanrator

@Composable
fun SearchGridItem(searchGridItemData: SearchGridItemData, modifier: Modifier =Modifier) {
    ConstraintLayout(
        modifier = modifier.clickable { }
            .defaultMinSize(minWidth = 160.dp, minHeight = 130.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(Color(parseColor(randomHexColorGanrator())))
            .padding(10.dp)
    ) {
        val (tvText, thumbnail) = createRefs()
        Text(
            text = searchGridItemData.topic,
            style = Typography.titleMedium,
            fontSize = 16.sp,
            color = Color.White,
            maxLines = 1,
            modifier = Modifier.constrainAs(tvText) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            })

        Image(
            modifier = Modifier
                .size(width = 60.dp, height = 60.dp)
                .clip(RoundedCornerShape(8.dp))
                .constrainAs(thumbnail) {
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
            contentScale = ContentScale.FillBounds,
            painter = painterResource(id = searchGridItemData.image),
            contentDescription = null,)
    }

}

data class SearchGridItemData(val topic: String, @DrawableRes val image: Int)

@Preview
@Composable
fun SearchGridItemPreview() {
    SearchGridItem(SearchGridItemData("Podcast", R.drawable.img_spotify_music_grid_1))
}
