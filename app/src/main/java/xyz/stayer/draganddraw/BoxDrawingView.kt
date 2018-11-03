package xyz.stayer.draganddraw

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View

class BoxDrawingView(context: Context, attrs: AttributeSet? = null): View(context, attrs) {

    companion object {
        const val TAG = "BoxDrawingView"
    }

    var mCurrentBox: Box? = null
    var mBoxen = mutableListOf<Box?>()
    var mBoxPaint = Paint()
    var mBackgroundPaint = Paint()

    init {
        mBoxPaint.color = 0x22ff0000.toInt()
        mBackgroundPaint.color = 0xfff8efe0.toInt()
    }

    override fun onDraw(canvas: Canvas?) {
        canvas!!.drawPaint(mBackgroundPaint)

        for (box in mBoxen) {
            val left = Math.min(box!!.origin.x, box.current.x)
            val right = Math.max(box.origin.x, box.current.x)
            val top = Math.min(box.origin.y, box.current.y)
            val bottom = Math.max(box.origin.y, box.current.y)
            canvas.drawRect(left, top, right, bottom, mBoxPaint)
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event == null) return false
        val current = PointF(event.x, event.y)
        val action =  when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                mCurrentBox = Box(current)
                mBoxen.add(mCurrentBox)
                "ACTION_DOWN"
            }
            MotionEvent.ACTION_MOVE -> {
                if (mCurrentBox != null) {
                    mCurrentBox!!.current = current
                    invalidate()
                }
                "ACTION_MOVE"
            }
            MotionEvent.ACTION_UP -> {
                mCurrentBox = null
                "ACTION_UP"
            }
            MotionEvent.ACTION_CANCEL -> {
                mCurrentBox = null
                "ACTION_CANCEL"
            }
            else -> "NULL"
        }

        Log.d(TAG, "$action at x=${current.x}, y=${current.y}")

        return true

    }
}