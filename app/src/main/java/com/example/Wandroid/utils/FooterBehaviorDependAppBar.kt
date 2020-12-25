package com.example.Wandroid.utils

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.appbar.AppBarLayout

/**
 * 知乎效果底部behavior 依赖于 AppBarLayout
 *
 * @author xujun  on 2016/11/30.
 * @email gdutxiaoxu@163.com
 */
class FooterBehaviorDependAppBar(context: Context?, attrs: AttributeSet?) :
    CoordinatorLayout.Behavior<View>(context, attrs) {
    //当 dependency instanceof AppBarLayout 返回TRUE，将会调用onDependentViewChanged（）方法
    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        return dependency is AppBarLayout
    }

    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        //根据dependency top值的变化改变 child 的 translationY
        val translationY = Math.abs(dependency.top).toFloat()
        Log.i(TAG, "onDependentViewChanged: " + dependency.top)
        child.translationY = translationY
        //Log.i(TAG, "onDependentViewChanged: " + translationY);
        return true
    }

    companion object {
        const val TAG = "xujun"
    }
}