package com.android.cleophee_itier_3076679_ass2

import android.graphics.Color
import android.graphics.Rect

class Cell {
    var ColorCell: Int = Color.BLACK;
    var isTouched: Boolean = false;
    val mine: Boolean = false;
    val uncovered: Boolean = false;
    var xStart: Float = 0.0f
    var xEnd: Float = 0.0f
    var yStart: Float = 0.0f
    var yEnd: Float = 0.0f
    lateinit var rect: Rect;
}