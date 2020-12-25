package com.example.Wandroid.mvp.view

import com.example.Wandroid.mvp.comm.BaseView

interface HotView :BaseView{
        fun <T> onHotSccuess(data:T);
         fun  onHotFailed(mes:String);
}