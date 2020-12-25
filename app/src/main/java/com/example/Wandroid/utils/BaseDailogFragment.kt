package com.example.Wandroid.utils;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import com.example.Wandroid.R


/**
 *Copyright (C), 2015-2020, XXX有限公司
 * @ClassName: BaseDailogFragment
 * @Description: java类作用描述
 * @Author: xueliang
 * @Date: 2020/11/12 0012 15:32
 *Description:
 *博客地址：https://blog.csdn.net/xueshao110?spm=1010.2135.3001.5113
 */
abstract class BaseDailogFragment: DialogFragment() {
    protected var rootView:View?=null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.MyMinDialogWidth)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         dialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog!!.setCancelable(true)
        dialog!!.setCanceledOnTouchOutside(true)
            if(rootView==null){
                rootView=  inflater.inflate(getLayout(),container,false)
            }
            initView(rootView)
             initData()

        return rootView;
    }

    abstract fun initData()

    abstract fun initView(rootView: View?)

    abstract fun getLayout(): Int
}
