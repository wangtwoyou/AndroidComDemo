package com.example.administrator.carplus.WIFITOOL

import android.content.Context
import android.net.wifi.WifiManager

class WifiTool(var context:Context) {
    fun isConnect(): Boolean {
        val manage = context.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        return manage.isWifiEnabled
    }

    fun wifiOpen(flag: Boolean): Boolean {
        val manager =  context.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        manager.isWifiEnabled = flag
        return isConnect()

    }

}