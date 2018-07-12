package com.example.administrator.carplus.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class ButtonDiy(context: Context?, attrs: AttributeSet?) : View(context, attrs),View.OnTouchListener{
    override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
        x = p1!!.x
        y = p1.y

        return true
    }


    var x:Float?=null
    var y:Float?=null

    override fun onDraw(canvas: Canvas?) {
        x = (canvas!!.width/2).toFloat()
        y = (canvas.height/2).toFloat()
        super.onDraw(canvas)
        val paint = Paint()
        paint.color = Color.WHITE
        paint.isAntiAlias=true
        canvas.drawCircle((canvas.width/2).toFloat(), (canvas.height/2).toFloat(), (width/2).toFloat(), paint)
        paint.color = Color.CYAN
        while(true)

            canvas.drawCircle(x!!, y!!,50f,paint)
}
}