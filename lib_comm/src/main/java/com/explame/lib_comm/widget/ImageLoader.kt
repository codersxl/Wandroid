package com.explame.lib_comm.widget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.ImageView


import com.explame.lib_network.R


/**
 * @author www.xl06.xyz (xueliang)
 * create by
 */

@SuppressLint("AppCompatCustomView")
class ImageLoader(context: Context?, attrs: AttributeSet?) : ImageView(context, attrs) {

    //旋转角度
    private var rotateDegree = 0
    private var mNeedRotate = false


    private fun initView() {
        setImageResource(R.mipmap.lod)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        mNeedRotate = true
        post(object : Runnable {
            override fun run() {
                rotateDegree += 30
                rotateDegree = if (rotateDegree <= 360) rotateDegree else 0
                invalidate()
                if (mNeedRotate) {
                    postDelayed(this, 100)
                }
            }
        })
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        mNeedRotate = false
    }

    override fun onDraw(canvas: Canvas) {
        canvas.rotate(rotateDegree.toFloat(), width / 2.toFloat(), height / 2.toFloat())
        super.onDraw(canvas)
    }

    init {
        initView()
    }
}