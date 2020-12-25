package com.example.Wandroid.utils
/**
 *Copyright (C), 2015-2020, XXX有限公司
 * @ClassName: Test
 * @Description: java类作用描述
 * @Author: xueliang
 * @Date: 2020/11/8 0008 21:21
 *Description:
 *博客地址：https://blog.csdn.net/xueshao110?spm=1010.2135.3001.5113
 */
import android.app.Activity
import android.os.Build
import android.view.View
import androidx.core.content.ContextCompat

/**
 * 控制页面的状态栏颜色
 *
 *
 */
object StutasBarUtils {

    fun setStatusBar(actitvy:Activity,actype:Int,colors:Int){
           if(Build.VERSION.SDK_INT>Build.VERSION_CODES.LOLLIPOP){
               if(actype==1){
                   actitvy.window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
               }else{
                   actitvy.window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
               }
               actitvy.window.statusBarColor=ContextCompat.getColor(actitvy,colors)

           }

    }

}