package com.example.Wandroid.utils;

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 *Copyright (C), 2015-2020, XXX有限公司
 * @ClassName: SpaceItemDecoration
 * @Description: java类作用描述
 * @Author: xueliang
 * @Date: 2020/11/9 0009 15:38
 *Description:
 *博客地址：https://blog.csdn.net/xueshao110?spm=1010.2135.3001.5113
 */
class SpaceItemDecoration(var space:Int ): RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.left = space;
        outRect.bottom = space;
        //由于每行都只有3个，所以第一个都是3的倍数，把左边距设为0
        if (parent.getChildLayoutPosition(view) %3==0) {
            outRect.left = 0;
        }
    }

}
