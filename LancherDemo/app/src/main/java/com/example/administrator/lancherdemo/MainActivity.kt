package com.example.administrator.lancherdemo

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var str = "666"
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
        btn.setOnClickListener {
            str = "888"
        }
        /*Observable.just(str)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.newThread())
                .subscribe {
                    tv.text = str
                }*/
        Log.i("activity","onCreate()")
    }

    override fun onResume() {
        super.onResume()
        et.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            @SuppressLint("SetTextI18n")
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Observable.just(p0)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe {
                    tv.text = p0
                }
            }
        })

    }
    /*override fun onResume() {
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
    }*/

}
