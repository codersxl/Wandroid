package com.example.Wandroid.Test

data class BaseBen<out T>(val errorCode:Int, val errorMsg:String, val data:T)