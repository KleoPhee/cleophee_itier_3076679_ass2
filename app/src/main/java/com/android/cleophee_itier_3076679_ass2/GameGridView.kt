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

    fun setColor(paint: Paint, rect: Rect, canvas: Canvas?)
    {
        paint.color = Color.BLACK
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

    private fun DrawBoard(canvas: Canvas?) {
        val paint = Paint()
        for (j in 0..4) {
            for (i in 0..4) {
                // to prevent any null value adding of '?'
                val first = Rect(
                    originX + 2 * i * cellSide,
                    originY + 2 * j * cellSide,
                    originX + (2 * i + 1) * cellSide,
                    originY + (2 * j + 1) * cellSide)
                setColor(paint, first, canvas)
                val second = Rect(
                    originX + (2 * i + 1) * cellSide,
                    originY + (2 * j + 1) * cellSide,
                    originX + (2 * i + 2) * cellSide,
                    originY + (2 * j + 2) * cellSide)
                setColor(paint, second, canvas)
                val third = Rect(
                    originX + (2 * i + 1) * cellSide,
                    originY+ 2 * j * cellSide,
                    originX + (2 * i + 2) * cellSide,
                    originY + (2 * j + 1) * cellSide)
                setColor(paint, third, canvas)
                val forth = Rect(
                    originX + 2 * i * cellSide,
                    originY+ (2 * j + 1) * cellSide,
                    originX + (2 * i + 1) * cellSide,
                    originY + (2 * j + 2) * cellSide)
                setColor(paint, forth, canvas)
            }
        }
    }

    //to know what to draw
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        DrawBoard(canvas)
    }
}