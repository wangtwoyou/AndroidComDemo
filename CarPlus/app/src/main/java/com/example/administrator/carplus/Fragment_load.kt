package com.example.administrator.carplus

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.LocalBroadcastManager
import android.support.v4.content.LocalBroadcastManager.getInstance
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.administrator.carplus.WIFITOOL.WifiTool
import kotlinx.android.synthetic.main.fragment_wifi_init.*

class Fragment_load : Fragment() {
    private var broad:BroadcastReceiver? = null
    private var localBroadcastManager:LocalBroadcastManager? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_wifi_init, container, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        localBroadcastManager = getInstance(this.activity!!)
        val filter = IntentFilter()
        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION)
        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION)

        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION)
        broad = object : BroadcastReceiver(){
            override fun onReceive(p0: Context?, p1: Intent?) {
                Toast.makeText(activity,p1!!.action,Toast.LENGTH_SHORT).show()
            }
        }
        if(broad!=null && localBroadcastManager!=null)
        localBroadcastManager!!.registerReceiver(broad!!,filter)

    }

    override fun onResume() {
        super.onResume()
        wifi_init()
        btn.setOnClickListener {
            localBroadcastManager!!.sendBroadcast(Intent(WifiManager.WIFI_STATE_CHANGED_ACTION))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if(broad!=null && localBroadcastManager!=null)
            localBroadcastManager!!.unregisterReceiver(broad!!)
    }

    private fun wifi_init() {
        val wifi = WifiTool(this.context!!)
        if(wifi.isConnect())
            wifi_flag.text = "已开启"
        else {
            wifi_flag.text = "未开启"
            if(wifi.wifiOpen(true))
                wifi_flag.text = "已开启"
        }
    }


}