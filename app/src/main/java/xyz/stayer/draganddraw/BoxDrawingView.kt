package xyz.stayer.draganddraw

import android.content.Context
import android.graphics.PointF
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View

class BoxDrawingView(context: Context, attrs: AttributeSet? = null): View(context, attrs) {

    companion object {
        const val TAG = "BoxDrawingView"
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event == null) return false
        val current = PointF(event.x, event.y)
        val action =  when (event.action) {
            MotionEvent.ACTION_DOWN -> "ACTION_DOWN"
            MotionEvent.ACTION_MOVE -> "ACTION_MOVE"
            MotionEvent.ACTION_UP -> "ACTION_UP"
            MotionEvent.ACTION_CANCEL -> "ACTION_CANCEL"
            else -> "NULL"
        }

        Log.d(TAG, "$action at x=${current.x}, y=${current.y}")

        return true

    }
}