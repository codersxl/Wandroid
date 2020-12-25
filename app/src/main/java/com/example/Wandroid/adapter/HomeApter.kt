package com.example.Wandroid.adapter
/**
 *Copyright (C), 2015-2020, XXX有限公司
 * @ClassName: Test
 * @Description: java类作用描述
 * @Author: xueliang
 * @Date: 2020/11/8 0008 21:21
 *Description:
 *博客地址：https://blog.csdn.net/xueshao110?spm=1010.2135.3001.5113
 */
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import java.util.ArrayList

class HomeApter(fm: FragmentManager, fragments: ArrayList<Fragment>) : FragmentPagerAdapter(fm) {
    private var data:ArrayList<Fragment>?=null
    init {
           data=fragments
    }
    override fun getCount(): Int {
      return data!!.size
    }

    override fun getItem(position: Int): Fragment {
        Log.e("sssssss","$position===")
         return data?.get(position)!!
    }


}