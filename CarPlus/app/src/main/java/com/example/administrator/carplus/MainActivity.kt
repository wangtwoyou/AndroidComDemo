package com.example.administrator.carplus

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.administrator.carplus.WIFITOOL.WifiTool
import kotlinx.android.synthetic.main.fragment_wifi_init.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragment_init()


    }

    private fun fragment_init() {
        supportFragmentManager.beginTransaction()
                .add(R.id.view_window,Fragment_load())
                .commitNow()
    }
}
