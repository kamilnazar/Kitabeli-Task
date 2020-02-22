package com.kamilnazar.kitabeli.util

import android.content.res.Resources
import android.util.DisplayMetrics
import kotlin.math.roundToInt


fun Int.pxToDp(): Float {
    val metrics: DisplayMetrics = Resources.getSystem().displayMetrics
    val dp = this / (metrics.densityDpi / 160f)
    return dp.roundToInt().toFloat()
}

fun Int.dpToPx(): Float {
    val metrics: DisplayMetrics = Resources.getSystem().displayMetrics
    val px = this * (metrics.densityDpi / 160f)
    return px.roundToInt().toFloat()
}
//fun Long.convertToHMmSs(): String? {
//    seconds
//    val s = seconds % 60
//    val m = seconds / 60 % 60
//    val h = seconds / (60 * 60) % 24
//    return String.format("%d:%02d:%02d", h, m, s)
//}