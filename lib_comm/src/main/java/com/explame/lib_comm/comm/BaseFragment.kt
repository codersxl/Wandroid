package com.example.Wandroid.mvp.comm
/**
 *Copyright (C), 2015-2020, XXX有限公司
 * @ClassName: Test
 * @Description: java类作用描述
 * @Author: xueliang
 * @Date: 2020/11/8 0008 21:21
 *Description:
 *博客地址：https://blog.csdn.net/xueshao110?spm=1010.2135.3001.5113
 */

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.explame.lib_comm.widget.UiLoading


abstract class BaseFragment<V, P : BasePrenster<V>>:Fragment() {
    private var BasemPrenster:P?=null;

    protected var con:Context ?=null
    var uiLoading: UiLoading? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        con=context

        if(BasemPrenster==null){
            BasemPrenster=createPrenster() as P
        }
        BasemPrenster?.bindView(this as V)

    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

         uiLoading = object : UiLoading(container?.context!!) {
            override fun getScuessView(): View {

                val  rootView = inflater.inflate(getLayout(), container, false)
                return rootView
            }
        }

        return  uiLoading
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(uiLoading)
        initData();
        initListner();
    }


    abstract fun getLayout(): Int


    abstract fun createPrenster():P
    abstract fun initView(rootView: View?)

    abstract fun initListner()

    abstract fun initData()
    fun getPrenster()=BasemPrenster
    override fun onDestroy() {
        super.onDestroy()

        BasemPrenster?.getBaseView()?.let {
            BasemPrenster?.unbindView()
        }
        BasemPrenster=null
    }

}




