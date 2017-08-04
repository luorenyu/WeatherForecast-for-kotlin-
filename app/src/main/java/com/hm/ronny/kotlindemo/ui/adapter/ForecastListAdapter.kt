package com.hm.ronny.kotlindemo.ui.adapter

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.hm.ronny.kotlindemo.R
import com.hm.ronny.kotlindemo.domain.module.Forecast
import com.hm.ronny.kotlindemo.domain.module.ForecastList
import com.hm.ronny.kotlindemo.extensions.ctx
import com.hm.ronny.kotlindemo.ui.adapter.ForecastListAdapter.ViewHolder
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

/**
 * Created by Ronny on 2017/8/2.
 */
class ForecastListAdapter(val weekForecast: ForecastList,val itemClick:(Forecast) -> Unit) : Adapter<ViewHolder>(){

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindForecast(weekForecast[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder{

//        val view = LayoutInflater.from(parent?.ctx).inflate(R.layout.item_list, parent,false)
        val view = LayoutInflater.from(parent?.ctx).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view,itemClick)
    }

    override fun getItemCount(): Int = weekForecast.size()

    class ViewHolder(view: View, val itemClick: (Forecast)->Unit): RecyclerView.ViewHolder(view){
        private val iconView: ImageView
        private val dateView: TextView
        private val descriptionView: TextView
        private val maxTemperatureView: TextView
        private val minTemperatureView: TextView

        init {
            iconView=view.find(R.id.icon)
            dateView=view.find(R.id.date)
            descriptionView=view.find(R.id.description)
            maxTemperatureView=view.find(R.id.maxTemperature)
            minTemperatureView=view.find(R.id.minTemperature)
        }

        fun bindForecast(forecast:Forecast){

            with(forecast){
                Picasso.with(itemView.context).load(forecast.iconUrl).into(iconView)
                dateView.text = forecast.date
                descriptionView.text=forecast.description
                maxTemperatureView.text= "${forecast.high}℃"
                minTemperatureView.text= "${forecast.low}℃"
                itemView.setOnClickListener{itemClick(forecast)}
            }
        }

    }

    interface OnItemClickListener{
        operator fun invoke(forest: Forecast)
    }

}
