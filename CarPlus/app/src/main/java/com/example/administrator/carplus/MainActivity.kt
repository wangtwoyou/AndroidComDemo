package com.example.administrator.carplus

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.administrator.carplus.fragment.FragmentLoad

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentInit()
    }

    private fun fragmentInit() {
        supportFragmentManager.beginTransaction()
                .add(R.id.view_window, FragmentLoad())
                .commitNow()
    }
}
