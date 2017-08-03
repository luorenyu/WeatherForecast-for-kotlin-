package com.hm.ronny.kotlindemo.activity

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import com.hm.ronny.kotlindemo.R
import com.hm.ronny.kotlindemo.adapter.ForecastListAdapter
import com.hm.ronny.kotlindemo.net.ForecastRequest
import org.jetbrains.anko.*

class WeatherActivity : AppCompatActivity() {

    val FLAG1:Boolean=true
    val FLAG2:Boolean=false
    var context:Context = this

    private val items=listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        val recyclerView = find<RecyclerView>(R.id.forecastlist)
        val layoutManager = LinearLayoutManager(this)
        val url = ""
        async {
            ForecastRequest(url)
            uiThread {
                longToast("request performed")
            }
        }
        recyclerView.layoutManager=layoutManager
        recyclerView.adapter=ForecastListAdapter(items)

    }

    //扩展函数,这就给TextView扩展了get和set两个方法
    public var TextView.text:CharSequence
        get() = getText()
        set(value) = setText(value)

    fun example(){

        //变量申明符号：val——不可变 var——可变
        //类型申明和转换
        val a:Boolean=true
        val b:String=a.toString()
        //逻辑运算
        val bitWiseOr=a or FLAG1
        val bitWiseAnd =FLAG1 and FLAG2
        //String 可以想数组一样去使用
        var string:String ="kotlin"
        string="ttt"
        val char=string[2]//取到了kotlin的第二个字符“o”
        for (m in string){
            print(m)
        }

        //映射对象到变量中
//        var f1=Forecast(Date(2017,8,4),28,"哈哈")
//        val (data,tem,detail)=f1
//        //等价于
//        val date=f1.component1()
//        val tem2=f1.component2()
//        val detail2=f1.component3()
    }


}
