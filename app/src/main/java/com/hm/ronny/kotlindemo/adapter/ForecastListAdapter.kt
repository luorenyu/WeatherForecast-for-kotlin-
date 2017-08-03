package com.hm.ronny.kotlindemo.adapter

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.View
import android.view.ViewGroup
import com.hm.ronny.kotlindemo.adapter.ForecastListAdapter.ViewHolder

/**
 * Created by Ronny on 2017/8/2.
 */
class ForecastListAdapter(val item:List<String>) : Adapter<ViewHolder>(){

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class ViewHolder(textView: View): RecyclerView.ViewHolder(textView)

}