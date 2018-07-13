package com.example.administrator.carplus


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import kotlinx.android.synthetic.main.fragment_wifi_init.*

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
* */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_wifi_init)
        //fragmentInit()
        btn.setOnClickListener {
            application.startActivity(Intent(applicationContext,Main2Activity::class.java))
        }
    }

    /*private fun fragmentInit() {
        supportFragmentManager.beginTransaction()
                .add(R.id.view_window, FragmentLoad())
                .commitNow()
    }*/
}
