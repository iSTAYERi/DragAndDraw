package xyz.stayer.draganddraw

import android.graphics.PointF

data class Box(
        val origin: PointF,
        var current: PointF
) {
    constructor(origin: PointF): this(origin, origin)
}