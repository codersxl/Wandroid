package com.example.Wandroid.mvp.view;

import com.example.Wandroid.mvp.comm.BaseView

/**
 *Copyright (C), 2015-2020, XXX有限公司
 * @ClassName: SearchView
 * @Description: java类作用描述
 * @Author: xueliang
 * @Date: 2020/11/11 0011 14:03
 *Description:
 *博客地址：https://blog.csdn.net/xueshao110?spm=1010.2135.3001.5113
 */
interface SearchView :BaseView{
    fun <T> onLoadMore(data:T)
    fun onLoadMoreErro(mes: String)

    fun onLoadMoreEmpty();
}
