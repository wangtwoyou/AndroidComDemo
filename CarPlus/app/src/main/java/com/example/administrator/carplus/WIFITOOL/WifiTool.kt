package com.example.administrator.carplus.wifitool

import android.content.Context
import android.net.wifi.WifiConfiguration
import android.net.wifi.WifiManager

class WifiTool(context:Context) {
    private val manage = context.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager

    fun isConnect(): Int {
        return when(manage.wifiState){
            WifiManager.WIFI_STATE_DISABLING -> WifiManager.WIFI_STATE_DISABLING //0 正在关闭
            WifiManager.WIFI_STATE_DISABLED -> WifiManager.WIFI_STATE_DISABLED //1 关闭
            WifiManager.WIFI_STATE_ENABLING -> WifiManager.WIFI_STATE_ENABLING //2 正在开启
            WifiManager.WIFI_STATE_ENABLED -> WifiManager.WIFI_STATE_ENABLED // 3 开启
            else -> WifiManager.WIFI_STATE_UNKNOWN //4 未知
        }
    }

    fun wifiOpen(flag: Boolean): Boolean {
        manage.isWifiEnabled = flag
        return isConnect() == WifiManager.WIFI_STATE_ENABLING || isConnect() == WifiManager.WIFI_STATE_ENABLED
    }

    fun localWifiFlag():ArrayList<WifiArray>?{
        return if(manage.connectionInfo == null)
            null
        else {
            val list = ArrayList<WifiArray>()
            list.add(WifiArray(manage.connectionInfo.ssid, manage.connectionInfo.ipAddress))
            list
        }
    }

    fun wifiList():List<WifiConfiguration>{
        return manage.configuredNetworks
    }

    class WifiArray(var SSID:String, var IP: Int)
}