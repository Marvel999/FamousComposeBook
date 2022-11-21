package com.marvel999.fuitemplet.Spotify.utill

import java.util.*

fun randomHexColorGanrator(): String {
    val random = Random()
    val nextInt: Int = random.nextInt(0xffffff + 1)
    val colorCode = String.format("#%06x", nextInt)
    return colorCode
}


fun <T> shuffle(list: MutableList<T>) {
    for (i in list.size - 1 downTo 1)
    { val j = kotlin.random.Random.nextInt(i + 1)
        val temp = list[i]
        list[i] = list[j]
        list[j] = temp
    }
}
