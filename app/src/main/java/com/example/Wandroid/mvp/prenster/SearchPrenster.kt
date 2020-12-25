package com.example.Wandroid.mvp.prenster;

import android.util.Log
import com.example.Wandroid.net.BaseUrl
import com.explame.lib_network.http.CallBack
import com.explame.lib_network.http.HttpUtils
import com.example.Wandroid.mvp.comm.BasePrenster
import com.example.Wandroid.mvp.model.SearchModel
import com.example.Wandroid.mvp.view.SearchView

/**
 *Copyright (C), 2015-2020, XXX有限公司
 * @ClassName: SearchPrenster
 * @Description: java类作用描述
 * @Author: xueliang
 * @Date: 2020/11/11 0011 14:03
 *Description:
 *博客地址：https://blog.csdn.net/xueshao110?spm=1010.2135.3001.5113
 */
class SearchPrenster:BasePrenster<SearchView> (){
    private var curnntPage:Int=0;
  private var mType:Boolean=false
    fun getonLoadMore(key:String){
        mType=true
        curnntPage++
        search(key,curnntPage)
        Log.e("curnntPage","$curnntPage")
    }


    fun search(key:String,Page:Int){
        HttpUtils.sendRequest(HttpUtils.createApi(BaseUrl::class.java).postSearch(Page,key),object :CallBack<SearchModel>{
            override fun onSuccess(data: SearchModel) {

                if(mType){

                    if(data.data.datas.isEmpty()){
                        curnntPage--
                        getBaseView()?.let {
                            it.onLoadMoreEmpty()
                        }
                    }else{
                        //刷新
                        getBaseView()?.let {
                            it.onLoadMore(data)
                        }
                    }

                }else{

                    if(data==null){
                        getBaseView()?.let {
                            it.onEmpty()
                        }
                    }else{
                        //加载
                        getBaseView()?.let {
                            it.onSuccess(data)
                        }
                    }

                }

            }

            override fun onFailed(erro: String) {

                if(mType){
                    //刷新
                    curnntPage--
                    getBaseView()?.let {
                        it.onLoadMoreErro(erro)
                    }
                }else{
                    //加载
                    getBaseView()?.let {
                        it.onFailed(erro)
                    }
                }

            }

        })

    }
}
