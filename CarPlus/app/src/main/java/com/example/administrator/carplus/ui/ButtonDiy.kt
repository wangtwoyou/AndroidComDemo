package com.example.administrator.carplus.ui

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class ButtonDiy(context: Context?, attrs: AttributeSet?) : View(context,attrs){

    private var movexy:Float?=null
    private var flag = false
    private var x:Float?=null
    private var y:Float?=null
    private var x0:Float?=null
    private var y0:Float?=null
    private var canvas:Canvas?=null
    private val paint = Paint()

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if(event!!.action == MotionEvent.ACTION_MOVE) {
            x = event.x
            y = event.y
            movexy = mathofxy(this.x!!,this.y!!)
            if(movexy!! <= canvas!!.width/2-50f)
                invalidate()
        }
        else if(event.action == MotionEvent.ACTION_UP){
            flag = false
            invalidate()
        }
        return true
    }

    fun mathofxy(xo:Float,yo:Float):Float{
        val x =  Math.abs(xo - this.x0!!)
        val y = Math.abs(yo-this.y0!!)
        return Math.sqrt(((x*x)+(y*y)).toDouble()).toFloat()
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        if(!flag) {
            this.canvas = canvas
            x = (canvas!!.width / 2).toFloat()
            y = (canvas.height / 2).toFloat()
            flag = true
            x0 = x
            y0 = y
        }
        super.onDraw(canvas)
        paint.color = Color.WHITE
        paint.isAntiAlias=true
        canvas!!.drawCircle((canvas.width/2).toFloat(), (canvas.height/2).toFloat(), (width/2).toFloat(), paint)
        paint.color = Color.CYAN
        paint.maskFilter = BlurMaskFilter(50f,BlurMaskFilter.Blur.OUTER)
        canvas.drawCircle(x!!, y!!,100f,paint)
}

}