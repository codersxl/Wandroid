/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: CustomViewpager
 * Author: Administrator
 * Date: 2020/11/18 0018 22:08
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
</desc></version></time></author> */
package com.example.Wandroid.weidget

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.view.MotionEvent
import android.view.View
import androidx.viewpager.widget.ViewPager

/**
 * @ClassName: CustomViewpager
 * @Description: java类作用描述
 * @Author: Administrator
 * @Date: 2020/11/18 0018 22:08
 */
/**
 * Created by vipui on 16/8/25.
 */
class CustomViewpager : ViewPager {
    private var current = 0
   var heights:Int = 0
    var isScrollble = true

    constructor(context: Context?) : super(context!!) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs) {}

    protected override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var heightMeasureSpec = heightMeasureSpec
        if (childCount > current) {
            val child: View = getChildAt(current)
            child.measure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED))
            val h = child.measuredHeight
            heights = h
        }
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY)
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    fun voidresetHeight(current: Int) {
        this.current = current
        if (childCount > current) {
            var layoutParams = layoutParams as LinearLayout.LayoutParams?
            if (layoutParams == null) {
                layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, height)
            } else {
                layoutParams.height = heights
            }
            setLayoutParams(layoutParams)
        }
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return if (!isScrollble) {
            true
        } else super.onTouchEvent(ev)
    }
}