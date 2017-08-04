package com.hm.ronny.kotlindemo.server


/**
 * 该文件中存放着所有天气json会用到的数据类
 * Created by Ronny on 2017/8/3.
 */
data class ForecastResult(val city: City, val list:List<Forecast>)

data class City(val id:Int, val name: String, val coord: Coordinates, val country:String, val population:Int)

data class Coordinates(val lon:Float,val lat:Float)

data class Forecast(val dt: Long, val temp: Temperature, val pressure: Float,
                    val humidity: Int, val weather: List<Weather>,
                    val speed: Float, val deg: Int, val clouds: Int,
                    val rain: Float)

data class Temperature(val day: Float, val min: Float, val max: Float,
                       val night: Float, val eve: Float, val morn: Float)

data class Weather(val id: Long, val main: String, val description: String,
                   val icon: String)