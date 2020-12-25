package com.example.Wandroid.utils;

import android.graphics.Rect
import android.view.Gravity
import android.view.View
import android.view.ViewTreeObserver
import android.view.WindowManager
import com.example.Wandroid.R
import kotlinx.android.synthetic.main.commdailog_layout.*

/**
 *Copyright (C), 2015-2020, XXX有限公司
 * @ClassName: CommDailog
 * @Description: java类作用描述
 * @Author: xueliang
 * @Date: 2020/11/12 0012 15:41
 *Description:
 *博客地址：https://blog.csdn.net/xueshao110?spm=1010.2135.3001.5113
 */
class CommDailog : BaseDailogFragment() {

    override fun initData() {

    }

    override fun initView(rootView: View?) {
        val attributes = dialog?.window?.attributes
        attributes?.width=WindowManager.LayoutParams.MATCH_PARENT
        attributes?.height= WindowManager.LayoutParams.WRAP_CONTENT
         dialog?.window?.setGravity(Gravity.BOTTOM)
        val decorView: View? = dialog?.window?.decorView
        decorView?.getViewTreeObserver()?.addOnGlobalLayoutListener(
                object : ViewTreeObserver.OnGlobalLayoutListener {
                    override fun onGlobalLayout() {
                        val r = Rect()
                        decorView.getWindowVisibleDisplayFrame(r)
                       val heig:Int= decorView.context.resources.displayMetrics.heightPixels
                        val diff:Int = heig - r.bottom;
                            if(diff!=0){
                              if(ln.paddingBottom!=diff){
                                        ln.setPadding(0,0,0,diff)
                              }
                            }else{
                                if(ln.paddingBottom!=0){
                                    ln.setPadding(0,0,0,0)
                                }
                            }
           //           Log.d("000", "" + screenHeight + "===" + softInputHeight + "==" + ln.getPaddingBottom())
                    }
                })
    }

    override fun getLayout()= R.layout.commdailog_layout
}
