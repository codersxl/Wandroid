package com.example.Wandroid.mvp.prenster
/**
 *Copyright (C), 2015-2020, XXX有限公司
 * @ClassName: Test
 * @Description: java类作用描述
 * @Author: xueliang
 * @Date: 2020/11/8 0008 21:21
 *Description:
 *博客地址：https://blog.csdn.net/xueshao110?spm=1010.2135.3001.5113
 */
import com.explame.lib_network.http.CallBack
import com.explame.lib_network.http.HttpUtils

import com.example.Wandroid.mvp.comm.BasePrenster
import com.example.Wandroid.net.BaseUrl
import com.example.Wandroid.mvp.model.MainModel
import com.example.Wandroid.mvp.view.MainView

class MainPrenster:BasePrenster<MainView>(){
   fun  ONSU(){

       getBaseView()?.let {
           it.onSuccess("hello")
       }
    }
   fun getu(){
      HttpUtils.sendRequest(HttpUtils.createApi(BaseUrl::class.java).getBaser(),object :CallBack<MainModel>{


          override fun onFailed(erro: String) {
              getBaseView().let {

                  it?.onSuccess(erro)
              }
          }

          override fun onSuccess(data: MainModel) {
              getBaseView().let {

                  it?.onSuccess(data)
              }
          }

      })
   }

}