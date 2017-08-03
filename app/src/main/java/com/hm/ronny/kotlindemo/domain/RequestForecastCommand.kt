package com.hm.ronny.kotlindemo.domain

import com.hm.ronny.kotlindemo.net.ForecastDataMapper
import com.hm.ronny.kotlindemo.net.ForecastRequest

/**
 * Created by Ronny on 2017/8/3.
 */
class RequestForecastCommand(val zipCode:String) : Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)

        return ForecastDataMapper().convertFromDataModel(
                forecastRequest.execute())

    }


}