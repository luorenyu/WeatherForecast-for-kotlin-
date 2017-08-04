package com.hm.ronny.kotlindemo.ui.activity

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.hm.ronny.kotlindemo.R
import org.jetbrains.anko.find

class MainActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = find<TextView>(R.id.test1)
        textView.text="Hello Kotlin"
        textView.setTextColor(Color.parseColor("#88ff0000"))
        textView.textSize = 25f
        textView.setOnClickListener {
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
