package com.example.administrator.lancherdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import AppUtil
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (AppUtil(this).getApps().size==0)
            tv.text = "shibai"
        else
            tv.text = AppUtil(this).getApps()[0]
    }
}
