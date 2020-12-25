package com.example.Wandroid.Test;


import android.content.Context
import android.util.Log
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 *Copyright (C), 2015-2020, XXX有限公司
 * @ClassName: RetrofitFactory
 * @Description: java类作用描述
 * @Author: xueliang
 * @Date: 2020/11/21 0021 18:58
 *Description:
 *博客地址：https://blog.csdn.net/xueshao110?spm=1010.2135.3001.5113
 */
class RetrofitFactory private constructor() {

    private lateinit var retrofit: Retrofit

    /**
     * 单利双重校验
     *
     *
     */
    companion object {
        val instance by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            RetrofitFactory()

        }


    }

    init {
        createRetrofit()
    }

    //创建对象
    fun createRetrofit():Retrofit {
        retrofit = Retrofit.Builder()
                .baseUrl("https://www.wanandroid.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        return retrofit
    }

    //创建方法
    fun <T> getSevers(sever: Class<T>): T {
        return retrofit.create(sever)
    }

    //发送请求

    fun <T> sendRequset(con:Context,Ob: Observable<T>, lisber:Back<T>){
           ShowD.Show(con)
           Ob.compose(RxThreadUtils.observableToMain())
                   .subscribe(object : Observer<T> {
                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onError(e: Throwable) {
                        ShowD.cancel()
                        lisber.onFailed(e.message.toString())
                        Log.e("失败", "${e.message}")
                    }

                    override fun onComplete() {

                    }

                    override fun onNext(t: T) {
                        ShowD.cancel()
                        lisber.onSuccess(t)
                        Log.e("失败", "${t}")
                    }
                })
    }
}


