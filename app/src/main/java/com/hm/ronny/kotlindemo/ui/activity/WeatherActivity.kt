package com.hm.ronny.kotlindemo.ui.activity

import android.app.ProgressDialog
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.TextView
import com.hm.ronny.kotlindemo.R
import com.hm.ronny.kotlindemo.ui.adapter.ForecastListAdapter
import com.hm.ronny.kotlindemo.domain.commands.RequestForecastCommand
import com.hm.ronny.kotlindemo.domain.module.Forecast
import kotlinx.android.synthetic.main.item_list.*
import org.jetbrains.anko.*

class WeatherActivity : AppCompatActivity() {

    val FLAG1:Boolean=true
    val FLAG2:Boolean=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_weather)
//        val recyclerView = find<RecyclerView>(R.id.forecastlist)
        var recyclerView=find<RecyclerView>(R.id.forecastlist)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager=layoutManager
        val progressDialog = ProgressDialog(this)
        with(progressDialog) {
            setMessage("数据加载中请稍等")
            setCancelable(true)
            show()
        }
        doAsync {
            val result = RequestForecastCommand("94043").execute()
            Log.e(javaClass.simpleName,result.toString())
            SystemClock.sleep(2000)
            uiThread {
                recyclerView.adapter=ForecastListAdapter(result){
                    toast(it.date)
                }
                progressDialog.dismiss()

            }
        }

    }

    override fun onResume() {
        super.onResume()

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
