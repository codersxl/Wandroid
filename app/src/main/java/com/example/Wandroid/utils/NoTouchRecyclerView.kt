package com.example.Wandroid.utils;

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView

/**
 *Copyright (C), 2015-2020, XXX有限公司
 * @ClassName: NoTouchRecyclerView
 * @Description: java类作用描述
 * @Author: xueliang
 * @Date: 2020/11/9 0009 18:50
 *Description:
 *博客地址：https://blog.csdn.net/xueshao110?spm=1010.2135.3001.5113
 */
class NoTouchRecyclerView:RecyclerView{
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onInterceptTouchEvent(e: MotionEvent?): Boolean {
        return false
    }

    override fun onTouchEvent(e: MotionEvent?): Boolean {
        return  true
    }
}
