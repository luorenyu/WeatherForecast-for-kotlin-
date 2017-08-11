package com.hm.ronny.kotlindemo.ui.activity

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hm.ronny.kotlindemo.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        test1.text="Hello Kotlin"
        test1.setTextColor(Color.parseColor("#88ff0000"))
        test1.textSize = 25f
        test1.setOnClickListener {
            toast2("Get Weather Go")
            val intent = Intent(this, WeatherActivity::class.java)
            startActivity(intent)
        }
    }


    fun add(x:Int,y:Int): Int=x+y


    //扩展函数toast2
    fun Context.toast2(message:String, tag:String =javaClass.simpleName, length:Int =Toast.LENGTH_LONG){
        Toast.makeText(this,"[$tag]$message",length).show()
    }


}
