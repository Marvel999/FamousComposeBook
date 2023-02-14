package com.marvel999.fuitemplet

import androidx.annotation.DrawableRes

data class FakePostData(
    @DrawableRes val userImage: Int,
    val userName: String,
    val likes: Int,
    val postDescription: String,
    val postTime: String,
    @DrawableRes val postImage: Int,
)

val usersPosts = listOf(

    FakePostData(
        userImage = R.drawable.model_s,
        userName = "Chris Sandler",
        likes = 22929,
        postDescription = "Super Amazing game best basket #superMan #Football",
        postTime = "10 hours ago",
        postImage = R.drawable.sportsscene,
    ),
    FakePostData(
        userImage = R.drawable.model_si,
        userName = "Celbkration Kristi",
        likes = 992929,
        postDescription = "We all love the krishna #God #Creator",
        postTime = "12 hours ago",
        postImage = R.drawable.krishnascnene,
    ),

    FakePostData(
        userImage = R.drawable.model_f,
        userName = "Sandra Bunika",
        likes = 62929,
        postDescription = "Best Railway Station in India #BeutifulStation #Railway #IndiaBest",
        postTime = "1 day ago",
        postImage = R.drawable.railwayscene,
    ),

    FakePostData(
        userImage = R.drawable.model_fi,
        userName = "Aniston vikky",
        likes = 1022929,
        postDescription = "Love my don boi, so cute #dogLover #CuteDog",
        postTime = "1 day ago",
        postImage = R.drawable.withdogscene,
    ),

    FakePostData(
        userImage = R.drawable.model_fo,
        userName = "Dyana Modphra",
        likes = 9052929,
        postDescription = "Woow Must watch anime bro!! #gojo #jKaisan",
        postTime = "2 days ago",
        postImage = R.drawable.animescene,
    ),

    FakePostData(
        userImage = R.drawable.model_t,
        userName = "HKristnia Mullian",
        likes = 90729229,
        postDescription = "An Amazing sports man always win our heart #KingKholi #LoveIndia",
        postTime = "2 days ago",
        postImage = R.drawable.viratscene,
    )
)