package com.example.Wandroid.Test

interface Back<T> {
    fun  onSuccess(data:T)
    fun onFailed(erro:String);
}