package com.marvel999.fuitemplet.Spotify.data

import com.marvel999.fuitemplet.R
import com.marvel999.fuitemplet.Spotify.component.MusicGridData
import com.marvel999.fuitemplet.Spotify.component.RowMusicData
import com.marvel999.fuitemplet.Spotify.component.SearchScreenComponent.SearchGridItem
import com.marvel999.fuitemplet.Spotify.component.SearchScreenComponent.SearchGridItemData

fun getMusicGridData(): List<MusicGridData> = listOf(
    MusicGridData(
        "Bollywood Gym Song Playlist(Updated Playlist)",
        R.drawable.img_spotify_music_grid_2
    ),
    MusicGridData("Hollywood", R.drawable.img_spotify_music_grid_1),
    MusicGridData("Hot hits", R.drawable.img_spotify_music_grid_3),
    MusicGridData("KingsMan from hollywood", R.drawable.img_spotify_music_grid_4)
)

fun getMusicRowData(): List<RowMusicData> = listOf(
    RowMusicData(
        "So Far Away (feat. Jamie Scott & Romy",
        "Swedish House Mix",
        R.drawable.img_spotify_song_1,
        true,
    ),
    RowMusicData(
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
        "Lorem Mix",
        R.drawable.img_spotify_song_2,
        imageDecoratorEnable = true
    ),
    RowMusicData(
        "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.",
        "House Mix",
        R.drawable.img_spotify_song_3,
        imageDecoratorEnable = true

    ),
    RowMusicData(
        "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.",
        "Swedish Mix",
        R.drawable.img_spotify_song_4,
        imageDecoratorEnable = true
    ),
    RowMusicData(
        "Matisse & Sadko Forever - Martin Garrix, ",
        "Garrix Mix",
        R.drawable.img_spotify_song_5,
        imageDecoratorEnable = true
    ),
    RowMusicData(
        "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old.",
        "Matisse Mix",
        R.drawable.img_spotify_song_6,
        imageDecoratorEnable = true
    ),
    RowMusicData(
        "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.",
        "Believable Mix",
        R.drawable.img_spotify_song_7,
        imageDecoratorEnable = true
    ),
    RowMusicData(
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris",
        "Consectetur Mix",
        R.drawable.img_spotify_song_8,
        imageDecoratorEnable = true
    ),
    RowMusicData(
        "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.",
        "Sed Mix",
        R.drawable.img_spotify_song_9,
        imageDecoratorEnable = true
    ),

    RowMusicData(
        "But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness.",
        "Happiness Mix",
        R.drawable.img_spotify_song_10,
        imageDecoratorEnable = true
    ),
    RowMusicData(
        " No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful.",
        "Pleasure Mix",
        R.drawable.img_spotify_song_11,
        imageDecoratorEnable = true
    ),
    RowMusicData(
        "At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga.",
        "Vero Mix",
        R.drawable.img_spotify_song_12,
        imageDecoratorEnable = true
    ),
)

fun getTodaysBiggestHitData(): List<RowMusicData> = listOf(
    RowMusicData(
        "Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus.",
        "Harum Mix",
        R.drawable.img_spotify_song_8,
    ),
    RowMusicData(
        "Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae.",
        "Temporibus Mix",
        R.drawable.img_spotify_song_7,
    ),
    RowMusicData(
        "On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment.",
        "Indignation Mix",
        R.drawable.img_spotify_song_2,
    ),
    RowMusicData(
        "So blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue; and equal blame belongs to those who fail in their duty through weakness of will, which is the same as saying through shrinking from toil and pain. ",
        "Swedish House Mix",
        R.drawable.img_spotify_song_1,
    ),
    RowMusicData(
        "These cases are perfectly simple and easy to distinguish.",
        "Perfect Mix",
        R.drawable.img_spotify_song_4,
    ),
    RowMusicData(
        "In a free hour, when our power of choice is untrammelled and when nothing prevents our being able to do what we like best, every pleasure is to be welcomed and every pain avoided.",
        "Swedish Mix",
        R.drawable.img_spotify_song_5,
    ),
    RowMusicData(
        "But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that pleasures have to be repudiated and annoyances accepted.",
        "Obligations Mix",
        R.drawable.img_spotify_song_6,
    ),
    RowMusicData(
        "The wise man therefore always holds in these matters to this principle of selection: he rejects pleasures to secure other greater pleasures, or else he endures pains to avoid worse pains.",
        "Principle Mix",
        R.drawable.img_spotify_song_3,

        ),
    RowMusicData(
        "These cases are perfectly simple and easy to distinguish.",
        "Pleasures Mix",
        R.drawable.img_spotify_song_9,
    ),

    RowMusicData(
        "Forever - Martin Garrix, Matisse & Sadko",
        "Swedish Mix",
        R.drawable.img_spotify_song_10,
    ),
    RowMusicData(
        "Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure.",
        "Loves Mix",
        R.drawable.img_spotify_song_11,
    ),
    RowMusicData(
        "To take a trivial example, which of us ever undertakes laborious.",
        "Sadko Mix",
        R.drawable.img_spotify_song_12,
    ),
)

fun getSearchGridList(): List<SearchGridItemData> = listOf<SearchGridItemData>(
   SearchGridItemData("Podcasts", R.drawable.img_spotify_music_grid_1),
   SearchGridItemData("Made For You", R.drawable.img_spotify_music_grid_2),
   SearchGridItemData("New releases", R.drawable.img_spotify_music_grid_3),
   SearchGridItemData("Hindi", R.drawable.img_spotify_music_grid_4),
   SearchGridItemData("Tamil", R.drawable.img_spotify_song_1),
   SearchGridItemData("English", R.drawable.img_spotify_song_2),
   SearchGridItemData("Punjabi", R.drawable.img_spotify_song_3),
   SearchGridItemData("Telugu", R.drawable.img_spotify_song_4),
   SearchGridItemData("Charts", R.drawable.img_spotify_song_5),
   SearchGridItemData("Live Events", R.drawable.img_spotify_song_6),
   SearchGridItemData("Pop", R.drawable.img_spotify_song_7),
   SearchGridItemData("Indie", R.drawable.img_spotify_song_8),
   SearchGridItemData("Trending", R.drawable.img_spotify_song_9),
   SearchGridItemData("Romance", R.drawable.img_spotify_song_10),
   SearchGridItemData("Discover", R.drawable.img_spotify_song_11),
   SearchGridItemData("Radio", R.drawable.img_spotify_song_12)
)