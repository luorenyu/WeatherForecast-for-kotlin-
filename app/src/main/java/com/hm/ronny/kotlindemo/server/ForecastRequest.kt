package com.hm.ronny.kotlindemo.server

import android.util.Log
import com.google.gson.Gson
import java.net.URL

/**
 * 用去请求网络数据
 * Created by Ronny on 2017/8/3.
 */
class ForecastRequest(val zipCode:String) {
    companion object {
        private val APP_ID="15646a06818f61f7b8d7823ca833e1ce"
        private val URL="http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL="${URL}&APPID=${APP_ID}&q="
    }


    fun execute(): ForecastResult? {
        Log.e(javaClass.simpleName,"请求链接：$COMPLETE_URL$zipCode")
        val forecastJsonStr=URL(COMPLETE_URL+zipCode).readText()
        Log.e(javaClass.simpleName,"请求链接：$COMPLETE_URL$zipCode 返回结果：$forecastJsonStr")
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }

}