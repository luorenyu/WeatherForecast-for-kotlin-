package com.hm.ronny.kotlindemo.extensions

import android.content.Context
import android.view.View

/**
 * Created by Ronny on 2017/8/4.
 */


val View.ctx: Context
    get() = context