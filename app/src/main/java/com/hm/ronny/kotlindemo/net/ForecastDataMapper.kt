package com.hm.ronny.kotlindemo.net

import com.hm.ronny.kotlindemo.domain.Forecast as ModelForecast
import com.hm.ronny.kotlindemo.domain.ForecastList
import java.text.DateFormat
import java.util.*

/**
 * 数据转换类
 * Created by Ronny on 2017/8/3.
 */
class ForecastDataMapper {
    fun convertFromDataModel(result: ForecastResult): ForecastList {
        return ForecastList(result.city.name, result.city.country,
                convertForecastListToDomain(result.list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.map { convertForecastItemToDomain(it) }
    }
    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt),
                forecast.weather[0].description, forecast.temp.max.toInt(),
                forecast.temp.min.toInt())
    }
    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }
}