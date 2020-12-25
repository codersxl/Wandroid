package com.explame.lib_network.http

import android.graphics.Rect
import android.util.Log
import android.view.View
import android.view.ViewTreeObserver.OnGlobalLayoutListener

object InputUtils {

    fun setInput(lin: View) {
        lin.getViewTreeObserver().addOnGlobalLayoutListener(
                object : OnGlobalLayoutListener {
                    override fun onGlobalLayout() {
                        val r = Rect()
                        lin.getWindowVisibleDisplayFrame(r)
                        val screenHeight: Int = lin.getRootView()
                                .getHeight()
                        //软键盘高度  softInputHeight
                        val softInputHeight = screenHeight - r.bottom
                        if (softInputHeight != 0) {
                            if (lin.getPaddingBottom() != softInputHeight) {
                                lin.setPadding(0, 0, 0, softInputHeight)
                            }
                        } else {
                            lin.setPadding(0, 0, 0, 0)
                        }
                        Log.d("000", "" + screenHeight + "===" + softInputHeight + "==" + lin.getPaddingBottom())
                    }
                })
    }

}