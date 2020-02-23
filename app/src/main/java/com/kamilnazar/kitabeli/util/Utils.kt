package com.kamilnazar.kitabeli.util

import android.content.res.Resources
import android.util.DisplayMetrics
import android.view.View
import kotlin.math.round
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

fun View.disableView() {
    this.isEnabled = false
    this.alpha = 0.5f
}

fun View.enableView() {
    this.isEnabled = true
    this.alpha = 1f
}

fun Double.round(decimals: Int): Double {
    var multiplier = 1.0
    repeat(decimals) { multiplier *= 10 }
    return round(this * multiplier) / multiplier
}