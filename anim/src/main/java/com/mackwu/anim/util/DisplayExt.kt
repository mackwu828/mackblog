package com.mackwu.anim.util

import android.content.Context


/**
 * px转sp
 */
fun Context.px2sp(pxValue: Float): Int {
    return (pxValue / resources.displayMetrics.scaledDensity + 0.5f).toInt()
}

/**
 * px转dp
 */
fun Context.px2dp(pxValue: Float): Int {
    return (pxValue / resources.displayMetrics.density + 0.5f).toInt()
}

/**
 * dp转px
 */
fun Context.dp2px(dpValue: Float): Int {
    return (dpValue * resources.displayMetrics.density + 0.5f).toInt()
}

/**
 * dp转sp
 */
fun Context.dp2sp(dpValue: Float): Int {
    return px2sp(dp2px(dpValue).toFloat())
}

/**
 * sp转px
 */
fun Context.sp2px(spValue: Float): Int {
    return (spValue * resources.displayMetrics.scaledDensity + 0.5f).toInt()
}

