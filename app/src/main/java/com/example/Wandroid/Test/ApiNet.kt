package com.example.Wandroid.Test

import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiNet {

    @FormUrlEncoded
    @POST("/user/login")
    fun Logins(@Field("username")username:String,@Field("password") password:String):Observable<BaseBen<LoginBen>>
}