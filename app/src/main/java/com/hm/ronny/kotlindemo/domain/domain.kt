package com.hm.ronny.kotlindemo.domain

import com.hm.ronny.kotlindemo.domain.Forecast as FCast
/**
 * Created by Ronny on 2017/8/3.
 */
public interface Command<T> {
    fun execute(): T
}

data class ForecastList(val city: String, val country: String,
                        val dailyForecast: List<FCast>)

data class Forecast(val date: String, val description: String, val high: Int,
                    val low: Int)