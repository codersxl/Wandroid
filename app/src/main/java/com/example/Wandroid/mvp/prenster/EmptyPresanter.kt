package com.example.Wandroid.mvp.prenster;

import com.example.Wandroid.net.BaseUrl
import com.explame.lib_network.http.CallBack
import com.explame.lib_network.http.HttpUtils
import com.example.Wandroid.mvp.comm.BasePrenster

import com.example.Wandroid.mvp.model.ChaptersModel
import com.example.Wandroid.mvp.model.TreeModel
import com.example.Wandroid.mvp.view.UserView

/**
 *Copyright (C), 2015-2020, XXX有限公司
 * @ClassName: UserPresanter
 * @Description: java类作用描述
 * @Author: xueliang
 * @Date: 2020/11/9 0009 14:15
 *Description:
 *博客地址：https://blog.csdn.net/xueshao110?spm=1010.2135.3001.5113
 */
class EmptyPresanter:BasePrenster<UserView>() {

     fun getShowData(){
         HttpUtils.sendRequest(HttpUtils.createApi(BaseUrl::class.java).getTree(),object :CallBack<TreeModel>{
             override fun onSuccess(data: TreeModel) {
                          getBaseView()?.let {
                              it.onSuccess(data)
                          }
             }

             override fun onFailed(erro: String) {
                 getBaseView()?.let {
                     it.onFailed(erro)
                 }
             }
         })
     }

    fun getShowDatas(){
        HttpUtils.sendRequest(HttpUtils.createApi(BaseUrl::class.java).getChaptersModels(),object :CallBack<ChaptersModel>{
            override fun onSuccess(data: ChaptersModel) {
                getBaseView()?.let {
                    it.onSuccess(data)
                }
            }

            override fun onFailed(erro: String) {
                getBaseView()?.let {
                    it.onFailed(erro)
                }
            }
        })
    }

}
