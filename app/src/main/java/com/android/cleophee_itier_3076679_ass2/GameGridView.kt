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
    var colorD = Color.BLACK //default color
    var isTouched = false
    val listCell = mutableListOf<Cell>()

    // list de mes carré de la class carré
    // assign value color to black to be able to change it and not redraw

    fun setColor(paint: Paint, rect: Rect, canvas: Canvas?)
    {
        paint.color = colorD
        paint.style = Paint.Style.FILL
        canvas?.drawRect(
            rect,
            paint
        )
        /*paint.color = Color.WHITE
        paint.style = Paint.Style.STROKE
        canvas?.drawRect(
            rect,
            paint
        )*/
    }

    private fun drawBoard(canvas: Canvas) {
        val paint = Paint()
        paint.color = colorD;

        val rectNB: Int = 11;
        val size = canvas.width
        val height = canvas.height
        val heightRect = height / rectNB
        val sizeRect = size / rectNB
        val rect = Rect(heightRect, sizeRect, sizeRect, heightRect);

        for (i in 0..rectNB) {
            canvas.save()
            for (j in 1..10) {
                canvas.save()
                canvas.translate((i * sizeRect).toFloat(), (j * sizeRect).toFloat())
                //canvas.drawRect(rect, paint)
                setColor(paint, rect, canvas)
                val x: Float = (i*sizeRect).toFloat()
                val y: Float = (j*sizeRect).toFloat()
                var cellElement = Cell();
                cellElement.ColorCell = colorD
                cellElement.xStart = x;
                cellElement.yStart = y;
                cellElement.rect = rect
                listCell.add(cellElement)
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

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val x = event?.getX();
        val y = event?.getY();

        if (event?.action == MotionEvent.ACTION_DOWN) {
            for (cell in listCell) {
                if (cell.rect.contains(event?.getRawX()?.toInt(), event?.getRawY()?.toInt())) {
                    if (!cell.isTouched) {
                        colorD = Color.GRAY
                        cell.isTouched = true
                    }
                }
            }
            invalidate();
        } /*else if (event?.action == MotionEvent.ACTION_DOWN && !isTouched){
            colorD = Color.GRAY;
            isTouched = true
            invalidate();
        }*/
        return super.onTouchEvent(event)
    }
}