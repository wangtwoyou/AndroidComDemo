package com.example.administrator.lancherdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*val applist = AppUtil(this).getApps()
        Observable.just(applist)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.newThread())
                .subscribe{
                    tv.append(it.toString())
                }*/
        /*Thread(Runnable {
            tv.text="123"
        }).start()*/
        Log.i("activity","onCreate()")
    }

    override fun onResume() {
        super.onResume()
        Log.i("activity","onResume()")
    }

    override fun onStart() {
        super.onStart()
        Log.i("activity","onStart()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("activity","onRestart()")
    }

    override fun onPause() {
        super.onPause()
        Log.i("activity","onPause()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("activity","onDestroy()")
    }

    override fun onStop() {
        super.onStop()
        Log.i("activity","onStop()")
    }
}
