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
import com.example.Wandroid.net.BaseUrl
import com.explame.lib_network.http.CallBack
import com.explame.lib_network.http.HttpUtils
import com.example.Wandroid.mvp.comm.BasePrenster
import com.example.Wandroid.mvp.model.LoginModel

import com.example.Wandroid.mvp.view.LoginView

class LoginPrenster:BasePrenster<LoginView>() {

          fun Login(edit_account:String,edit_pwd:String){

              HttpUtils.sendRequest(HttpUtils.createApi(BaseUrl::class.java).login(edit_account,edit_pwd),object :CallBack<LoginModel>{
                  override fun onSuccess(data: LoginModel) {
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