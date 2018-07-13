package com.example.administrator.carplus.ui


import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.Toast


class ButtonDiy(context: Context?, attrs: AttributeSet?) : View(context,attrs){
   /*              垃圾代码
    val ontouchlisteners = ArrayList<FragmentListener>()

    private var fragmentlistener :FragmentListener?=null
    fun setFragmentListener(f:FragmentListener){
        fragmentlistener = f
    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        for(i in ontouchlisteners){
            fragmentlistener!!.onTouch(event!!)
        }
        return super.dispatchTouchEvent(event)
    }

    fun registerMyOnTouchListener(frafment: FragmentListener) {
        ontouchlisteners.add(frafment)
    }

    fun unregisterMyOnTouchListener(frafment: FragmentListener) {
        ontouchlisteners.remove(frafment)
    }

    /**/*/
    /*var s:onTouch?=null
    interface onTouch{
       fun onTouch(event: MotionEvent?)
   }
    fun setOnTouchListenerb(onTouch: onTouch){
       s = onTouch
   }*/

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Toast.makeText(context,"rrrr",Toast.LENGTH_SHORT).show()
        return false
    }
    private var x:Float?=null
    private var y:Float?=null

    override fun onDraw(canvas: Canvas?) {
        x = (canvas!!.width/2).toFloat()
        y = (canvas.height/2).toFloat()
        super.onDraw(canvas)
        val paint = Paint()
        paint.color = Color.WHITE
        paint.isAntiAlias=true
        canvas.drawCircle((canvas.width/2).toFloat(), (canvas.height/2).toFloat(), (width/2).toFloat(), paint)
        paint.color = Color.CYAN
        canvas.drawCircle(x!!, y!!,50f,paint)
}

}