package com.example.Wandroid.net

/**
 *Copyright (C), 2015-2020, XXX有限公司
 * @ClassName: Test
 * @Description: java类作用描述
 * @Author: xueliang
 * @Date: 2020/11/8 0008 21:21
 *Description:
 *博客地址：https://blog.csdn.net/xueshao110?spm=1010.2135.3001.5113
 */

import com.example.Wandroid.mvp.model.*

import io.reactivex.Observable
import retrofit2.http.*

interface BaseUrl {

    @GET("/")
    fun getBaser(): Observable<MainModel>
    ///article/list/0/json


    //登录/user/register
    @FormUrlEncoded
    @POST("/user/login")
    fun login(@Field("username") username: String, @Field("password") password: String): Observable<LoginModel>

    /**
     *
     * /user/register
     *  username,password,repassword
     * 方法：POST
     *
     */
    fun register()

    /**
     * https://www.wanandroid.com/article/list/0/json
     *方法：GET
     * 参数：页码，拼接在连接中，从0开始。
     */
    fun getHome()

    /**
     *https://www.wanandroid.com/banner/json
     *方法：GET
     *参数：无
     */
    fun getBanner()

    /**
     *
     * 置顶文章
     *  https://www.wanandroid.com/article/top/json
     *
     */

    /**
     * https://www.wanandroid.com/lg/coin/userinfo/json
     * 积分
     *
     */
    @GET("/tree/json")
    fun getTree(): Observable<TreeModel>

    //    https://wanandroid.com/wxarticle/list/408/1/json
//    方法：GET
//    参数：
//    公众号 ID：拼接在 url 中，eg:405
//    公众号页码：拼接在url 中，eg:1
    //https://wanandroid.com/wxarticle/chapters/json
//@GET("/wxarticle/chapters/json")
//fun getChaptersModel():Observable<Hello>
//    @GET("/wxarticle/chapters/json")
//    fun getChaptersModels():Observable<Hello>
    @GET("/wxarticle/chapters/json")
    fun getChaptersModels(): Observable<ChaptersModel>

    @FormUrlEncoded
    @POST("/article/query/{path}/json")
    fun postSearch(@Path("path") path: Int, @Field("k") key: String): Observable<SearchModel>

    //https://www.wanandroid.com/
    @GET("/hotkey/json")
    fun getHotkey(): Observable<HotWordModel>
}