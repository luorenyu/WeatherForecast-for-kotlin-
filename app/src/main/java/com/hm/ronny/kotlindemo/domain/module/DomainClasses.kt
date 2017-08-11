package com.hm.ronny.kotlindemo.domain.module

import com.hm.ronny.kotlindemo.domain.module.Forecast
/**
 * Created by Ronny on 2017/8/3.
 */
public interface Command<T> {
    fun execute(): T
}

data class ForecastList(val city: String, val country: String,
                        val dailyForecast: List<Forecast>){
    operator fun get(position:Int) = dailyForecast[position]
    fun size():Int=dailyForecast.size
}

data class Forecast(val date: String, val description: String, val high: Int,
                    val low: Int,val iconUrl:String)