package com.android.cleophee_itier_3076679_ass2

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.Toast

class GameGridView(context: Context?, attrs: AttributeSet?) :
    View(context, attrs)
{
    private val cellSide: Int = 100
    private val originX: Int = 35
    private val originY: Int = 200
    var colorD = Color.BLACK //default color
    var colorY = Color.YELLOW
    // assign value color to black to be able to change it and not redraw

    fun setColor(paint: Paint, rect: Rect, canvas: Canvas?)
    {
        paint.color = colorD
        paint.style = Paint.Style.FILL
        canvas?.drawRect(
            rect,
            paint
        )
        paint.color = Color.WHITE
        paint.style = Paint.Style.STROKE
        canvas?.drawRect(
            rect,
            paint
        )
    }

    private fun drawBoard(canvas: Canvas) {
        val paint = Paint()
        paint.color = colorD;

        val rectNB: Int = 10;
        val size = canvas.width
        val height = canvas.height
        val heightRect = height / rectNB
        val sizeRect = size / rectNB
        val rect = Rect(heightRect, sizeRect, sizeRect, heightRect);

        for (i in 0..rectNB) {
            canvas.save()
            for (j in 0..rectNB) {
                canvas.save()
                canvas.translate((i * sizeRect).toFloat(), (j * sizeRect).toFloat())
                setColor(paint, rect, canvas)
                canvas.restore()
            }
            canvas.restore()
        }
    }

    //to know what to draw
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawBoard(canvas)
    }
}