package com.explame.lib_network.http

/**
 *Copyright (C), 2015-2020, XXX有限公司
 * @ClassName: Test
 * @Description: java类作用描述
 * @Author: xueliang
 * @Date: 2020/11/8 0008 21:21
 *Description:
 *博客地址：https://blog.csdn.net/xueshao110?spm=1010.2135.3001.5113
 */

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit

import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

import java.util.concurrent.TimeUnit
import okhttp3.logging.HttpLoggingInterceptor as HttpLoggingInterceptor

object HttpUtils {
    private var mokHttpClient: OkHttpClient? = null
    private val mHttpLoggingInterceptor: HttpLoggingInterceptor? = null
    fun getUrl(isTest: Boolean): String = if (isTest) Const.BASE_TEST_URL else Const.BASE_URL

    /**
     * http://api.coincent.cn/
     */
    fun <T> createApi(clas: Class<T>) = Retrofit.Builder()
            .baseUrl(Const.BASE_TEST_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(getOkHttpClent())
            .build()
            .create(clas)

    fun getOkHttpClent(): OkHttpClient? {
        if (mokHttpClient == null) {
            mokHttpClient = OkHttpClient.Builder()
                    .addInterceptor(getInterceptor())
                    .connectTimeout(3000, TimeUnit.SECONDS)
                    .build()
        }
        return mokHttpClient
    }


    fun getInterceptor(): Interceptor? {
        val mHttpLoggingInterceptor = HttpLoggingInterceptor();
        mHttpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return mHttpLoggingInterceptor
    }

    //请求
    fun <T> sendRequest(ob: Observable<T>, litsner: CallBack<T>) {
                ob.subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<T> {
                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onNext(t: T) {
                        t.let {
                            ThreadUtils.runOnUiThread(object : Runnable {
                                override fun run() {
                                    litsner.onSuccess(it)
                                }

                            })

                        }
                    }

                    override fun onError(e: Throwable) {
                        ThreadUtils.runOnUiThread(object : Runnable {
                            override fun run() {
                                e.message?.let { litsner.onFailed(it) }
                            }

                        })

                    }

                    override fun onComplete() {

                    }
                })


    }

}