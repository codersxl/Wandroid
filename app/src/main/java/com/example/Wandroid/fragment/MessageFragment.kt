package com.example.Wandroid.fragment
/**
 *Copyright (C), 2015-2020, XXX有限公司
 * @ClassName: Test
 * @Description: java类作用描述
 * @Author: xueliang
 * @Date: 2020/11/8 0008 21:21
 *Description:
 *博客地址：https://blog.csdn.net/xueshao110?spm=1010.2135.3001.5113
 */
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.Wandroid.R
import com.example.Wandroid.mvp.comm.BaseFragment
import com.example.Wandroid.mvp.prenster.LoginPrenster
import com.example.Wandroid.mvp.view.LoginView
import com.explame.lib_comm.widget.UiLoading

class MessageFragment: BaseFragment<LoginView, LoginPrenster>(),LoginView {
    override fun getLayout(): Int {
        return R.layout.fragment_message
    }

    override fun createPrenster(): LoginPrenster {

        return LoginPrenster()
    }

    override fun initView(rootView: View?) {

    }

    override fun initListner() {

    }

    override fun initData() {

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("-B-","onCreate()")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("-B-","onPause()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("-B-","onPause()")
    }

    override fun onPause() {
        super.onPause()
        Log.d("-B-","onPause()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("-B-","onDestroy()")
    }

    override fun <T> onSuccess(data: T) {

    }

    override fun onFailed(mes: String) {

    }

    override fun onlading() {
        uiLoading?.upDateUi(UiLoading.netstatus.Loding)
    }

    override fun onEmpty() {

    }

}