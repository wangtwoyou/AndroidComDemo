package com.example.administrator.carplus.fragment

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.administrator.carplus.R
import com.example.administrator.carplus.wifitool.WifiTool
import kotlinx.android.synthetic.main.fragment_wifi_init.*
/*
* 2018/7/10 问题：1.收不到外部发送的广播  原因：使用了localBroadcastManage 解决：将localroadcastManage替换
*                2.获取不到SSID 原因不明
*                3.逻辑有问题 日后再改 原因 太菜
* */

class FragmentLoad : Fragment() {
    private var wifi:WifiTool? = null
    private var broad:BroadcastReceiver? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_wifi_init, container, false)

    @SuppressLint("SetTextI18n")
    override fun onStart() {
        super.onStart()
        wifiInit()
        val filter = IntentFilter()
        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION)
        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION)
        filter.addAction(WifiManager.SUPPLICANT_STATE_CHANGED_ACTION)
        broad = object : BroadcastReceiver(){
            @SuppressLint("SetTextI18n")
            override fun onReceive(p0: Context?, p1: Intent?) {
                when(p1!!.action){
                    WifiManager.WIFI_STATE_CHANGED_ACTION ->
                        when(wifi!!.isConnect()) {
                            WifiManager.WIFI_STATE_DISABLING -> wifi_flag.text = "WIFI已被手动关闭!请自己手动打开"
                            WifiManager.WIFI_STATE_ENABLING -> wifi_flag.text="手动打开了WIFI"
                            WifiManager.WIFI_STATE_ENABLED -> wifi_flag.text="开启成功"
                        }
                }
            }
        }
        activity!!.registerReceiver(broad!!,filter)
    }

    override fun onDestroy() {
        super.onDestroy()
        if(broad!=null )
            activity!!.unregisterReceiver(broad!!)
    }

    @SuppressLint("SetTextI18n")
    private fun wifiInit() {
        wifi = WifiTool(this.context!!)
        when(wifi!!.isConnect()){
            WifiManager.WIFI_STATE_ENABLING -> wifi_flag.text = "开启wifi中..."
            WifiManager.WIFI_STATE_ENABLED -> {
                wifi_flag.text = "开启成功，搜索WIFI列表"
                val ip = wifi!!.localWifiFlag()!![0].IP
                wifi_flag.append("IP:${(ip and 0xFF)}"+ "." + (ip shr 8 and 0xFF) + "." + (ip shr 16 and 0xFF) + "." + (ip shr 24 and 0xFF))
            }
            WifiManager.WIFI_STATE_DISABLED -> {
                wifi_flag.text="wifi处于关闭状态，正在开启"
                wifi!!.wifiOpen(true)
            }
            else -> wifi_flag.text = "wifi开启失败"
        }
    }



}