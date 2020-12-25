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
import android.view.Window
import com.example.Wandroid.R
import com.example.Wandroid.adapter.HomeFragmentAapter
import com.example.Wandroid.mvp.comm.BaseFragment
import com.example.Wandroid.mvp.prenster.MainPrenster
import com.example.Wandroid.mvp.view.MainView
import com.explame.lib_comm.widget.UiLoading


import com.google.android.material.appbar.AppBarLayout


class HomeFragment : BaseFragment<MainView, MainPrenster>(), AppBarLayout.OnOffsetChangedListener,
    MainView {
    var mdatas = ArrayList<String>()
    private var window: Window? = null
    protected var userAdapter: HomeFragmentAapter? = null
    override fun getLayout(): Int {
        return R.layout.fragment_home
    }

    override fun createPrenster(): MainPrenster {

        return MainPrenster()
    }

    override fun initView(rootView: View?) {


//         userAdapter = HomeFragmentAapter(con);
//        home_recyview.adapter=userAdapter
//        val linearLayoutManager = LinearLayoutManager(context)
//        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
//        home_recyview.layoutManager=linearLayoutManager
//        home_recyview.isNestedScrollingEnabled = false
    }

    override fun initListner() {

    }


    override fun onResume() {
        super.onResume()


    }

    override fun onPause() {
        super.onPause()

    }


    override fun initData() {
        //val marqueeText: ScrollTextView = findViewById(R.id.tv)
        getPrenster()?.let {
            it.ONSU()
        }
        val demographicsList: MutableList<String> = ArrayList()

        demographicsList.add("今日测试股票 上市")
        demographicsList.add("今日科伦药业 中国人保 可申购")
        demographicsList.add("今日中国平安 上市")



        for (i in 0..100) {
            mdatas.add("$i")
        }
        userAdapter?.updateData(mdatas)

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("-A-", "onPause()")
    }


    override fun onDestroy() {
        super.onDestroy()

    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {

//        if (verticalOffset <= -head_layout.getHeight() / 2) {
//            collapsingToolbarLayout.setTitle("hello");
//            //使用下面两个CollapsingToolbarLayout的方法设置展开透明->折叠时你想要的颜色
//            collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
//            collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.white));
//            // window.setStatusBarColor(getResources().getColor(R.color.fuck));
//            window?.setStatusBarColor(Color.TRANSPARENT);
//        } else {
//            collapsingToolbarLayout.setTitle("");
//            window?.setStatusBarColor(Color.TRANSPARENT);
//            // activity?.window?.statusBarColor= ContextCompat.getColor(activity!!,Color.TRANSPARENT)
//        }
    }

    override fun <T> onSuccess(data: T) {
        //uiLoading?.upDateUi(UiLoading.netstatus.Scuess);
        //Toast.makeText(getActivity(), "-重新加载了--", Toast.LENGTH_SHORT).show();
        Log.e("00", "---------------")
    }

    override fun onFailed(mes: String) {
        uiLoading?.upDateUi(UiLoading.netstatus.Erro);
        uiLoading!!.onErroClick = object : UiLoading.OnErroClick {
            override fun onItemClick() {
                //  Toast.makeText(getActivity(), "-重新加载了--", Toast.LENGTH_SHORT).show();
            }
        }
    }

    override fun onlading() {
        uiLoading?.upDateUi(UiLoading.netstatus.Loding);
    }

    override fun onEmpty() {
        uiLoading?.upDateUi(UiLoading.netstatus.Empty);
    }


}