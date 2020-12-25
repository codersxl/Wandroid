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
import android.view.View
import com.example.Wandroid.R
import com.example.Wandroid.mvp.comm.BaseFragment
import com.example.Wandroid.mvp.prenster.MainPrenster
import com.example.Wandroid.mvp.view.MainView

class VideoFragment:BaseFragment<MainView,MainPrenster>() {
    override fun getLayout(): Int {
        return R.layout.fragment_video
    }

    override fun createPrenster(): MainPrenster {

        return MainPrenster()
    }

    override fun initView(rootView: View?) {

    }

    override fun initListner() {

    }

    override fun initData() {

    }
}