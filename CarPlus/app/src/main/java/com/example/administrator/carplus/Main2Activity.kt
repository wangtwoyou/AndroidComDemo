package com.example.administrator.carplus

import android.app.Activity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.fragment_control.*

class Main2Activity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_control)
        bttn.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                return false
            }
        })

    }
    /*override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        a = ev
        if(ev = MotionEvent.ACTION_MOVE)
        return super.dispatchTouchEvent(ev)
    }*/
}
