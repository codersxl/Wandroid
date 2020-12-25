/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ChildTouchListener
 * Author: Administrator
 * Date: 2020/11/9 0009 19:47
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
</desc></version></time></author> */
package com.example.Wandroid.utils


import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration

/**
 * @ClassName: ChildTouchListener
 * @Description: java类作用描述
 * @Author: Administrator
 * @Date: 2020/11/9 0009 19:47
 */
class ChildTouchListener(view: View) : View.OnTouchListener {
    private var downX = 0f
    private var downY = 0f
    private val touchSlop: Float
    private val view: View
    override fun onTouch(v: View?, event: MotionEvent): Boolean {
        when (event.getActionMasked()) {
            MotionEvent.ACTION_DOWN -> {
                downX = event.getX()
                downY = event.getY()
            }
            MotionEvent.ACTION_UP -> if (Math.abs(event.getY() - downY) < touchSlop && Math.abs(
                    event.getX() - downX
                ) < touchSlop
            ) {
                view.performClick()
            }
        }
        return false
    }

    init {
        this.view = view
        touchSlop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop().toFloat()
    }
}