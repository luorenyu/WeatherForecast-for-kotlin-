package com.hm.ronny.kotlindemo

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import cn.com.onebank.libesignature.ESignatureCallback
import cn.com.onebank.libesignature.ESignatureUtils
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import java.lang.Exception

class MainActivity : AppCompatActivity() , ESignatureCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = find<TextView>(R.id.test1)
        textView.text="Hello Kotlin"
        textView.setTextColor(Color.parseColor("#88ff0000"))
        textView.textSize = 25f

        textView.setOnClickListener {
            toast("hello Kotlin World")
            ESignatureUtils.getInstance().init(this, "BANK_OF_HUATONG", "APP_BANK_OF_HUATONG")
            ESignatureUtils.getInstance().callback = this
            ESignatureUtils.getInstance().reqRandom("name","0","12344444444","44444","33333333333333333")
        }
    }

    fun add(x:Int,y:Int): Int=x+y

    fun toast(message:String,tag:String =javaClass.simpleName,length:Int =Toast.LENGTH_LONG){
        Toast.makeText(this,"[$tag]$message",length).show()
        val dog=Dog()
        dog.name="cat"
    }

    override fun onSignSuccess() {

    }

    override fun onSignFailure(p0: Exception?) {

        toast(p0.toString())
    }

    override fun onReqRandomSuccess(p0: String?) {

        if (p0 != null) {
            toast(p0)
        }
    }

    class Dog{
        var name:String=""
    }

}
