package com.example.Wandroid

import android.app.Application
import android.content.Context
import android.os.Handler


class MyApp:Application (){
    private var con:Context?=null

    override fun onCreate() {
        super.onCreate()
        con=this
    }

    public fun getHandler(): Handler {
        return Handler()
    }

    fun getAppliction(): Context? {
        return this.con
    }
}
