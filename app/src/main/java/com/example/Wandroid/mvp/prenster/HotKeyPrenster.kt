package com.example.Wandroid.mvp.prenster;

import com.example.Wandroid.net.BaseUrl
import com.explame.lib_network.http.CallBack
import com.explame.lib_network.http.HttpUtils
import com.example.Wandroid.mvp.comm.BasePrenster
import com.example.Wandroid.mvp.model.HotWordModel
import com.example.Wandroid.mvp.view.HotView

/**
 *Copyright (C), 2015-2020, XXX有限公司
 * @ClassName: HotKeyPrenster
 * @Description: java类作用描述
 * @Author: xueliang
 * @Date: 2020/11/11 0011 17:43
 *Description:
 *博客地址：https://blog.csdn.net/xueshao110?spm=1010.2135.3001.5113
 */
class HotKeyPrenster:BasePrenster<HotView>(){



    fun getHotWord(){

        HttpUtils.sendRequest( HttpUtils.createApi(BaseUrl::class.java).getHotkey(),object :CallBack<HotWordModel>{
            override fun onSuccess(data: HotWordModel) {
                       getBaseView()?.let {
                           it.onHotSccuess(data)
                       }
            }

            override fun onFailed(erro: String) {
                getBaseView()?.let {
                    it.onHotFailed(erro)
                }
            }

        })
    }
}
