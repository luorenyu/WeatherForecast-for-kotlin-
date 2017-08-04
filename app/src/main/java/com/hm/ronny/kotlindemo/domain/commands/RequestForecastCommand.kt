package com.hm.ronny.kotlindemo.domain.commands

import com.hm.ronny.kotlindemo.domain.module.Command
import com.hm.ronny.kotlindemo.domain.module.ForecastList
import com.hm.ronny.kotlindemo.server.ForecastDataMapper
import com.hm.ronny.kotlindemo.server.ForecastRequest

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