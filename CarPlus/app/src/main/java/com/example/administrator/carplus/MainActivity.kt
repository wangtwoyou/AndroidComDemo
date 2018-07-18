package com.example.administrator.carplus

import android.app.Notification
import android.app.NotificationManager
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.administrator.carplus.fragment.FragmentLoad

/*
                                问题说明

* 2018/7/10      1.收不到外部发送的广播  原因：使用了localBroadcastManage 解决：将localroadcastManage替换
*                2.获取不到SSID 原因不明
*                3.逻辑有问题 日后再改 原因 太菜
*
* 2018/7/11     一天都在看linux,没有碰android
*
* 2018/7.12      自定义的view不会设置点击事件，早点解决（done）
*
* 2018/7.13      fragment中添加了自定义的view，但是触摸事件没有生效
*                目前解决办法：不用fragment,改用activity，日后慢慢研究
*
* 2018/7.16      上午：问题解决，自定义view的点击事件没问题了，上星期的问题在于，最上层有一层view遮挡，
*                导致触摸无效，小问题是小问题，但是需要注重细节。
*
*
*
*
* */

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentInit()
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val mbuilder = Notification.Builder(this)
                .setContentTitle("这是测试欸")
                .setContentText("这也是测试")
                .setTicker("收到测试")
                .setSmallIcon(null)//这边有问题，可能一定要设置图片
                .build()
        manager.notify(0,mbuilder)

    }

    private fun fragmentInit() {
        supportFragmentManager.beginTransaction()
                .add(R.id.view_window, FragmentLoad())
                .commitNow()
    }

}
