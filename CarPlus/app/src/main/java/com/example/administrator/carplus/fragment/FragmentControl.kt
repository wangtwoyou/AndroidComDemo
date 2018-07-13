package com.example.administrator.carplus.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.administrator.carplus.R
import com.example.administrator.carplus.ui.ButtonDiy
import kotlinx.android.synthetic.main.fragment_control.*
/*不被使用！！！暂时弃用！！！*/
class FragmentControl : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_control, container, false)

    @SuppressLint("ClickableViewAccessibility")
    override fun onStart() {
        super.onStart()
        ff.setOnClickListener {
            Toast.makeText(context,"ganma",Toast.LENGTH_SHORT).show()
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*ButtonDiy(context,null).registerMyOnTouchListener(object {
            /*override fun onTouch(ev: MotionEvent) {
                Toast.makeText(context,"oooo",Toast.LENGTH_SHORT).show()
            }*/
        })*/
    }


}