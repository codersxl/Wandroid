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
import androidx.fragment.app.Fragment
import com.example.Wandroid.fragment.*

object FragmentHelper {

    private val homeFragments by lazy {
        HomeFragment()
    }

    private val userFragments by lazy {
        UserFragment()
    }

    private val messageFragment by lazy {
        MessageFragment()
    }
    private val videoFragment by lazy {
        VideoFragment()
    }
    private  val EmptyFragment by lazy {
        EmptyFragment()
    }

    public fun getFragment(index:Int):Fragment{
        var Fragments:Fragment?=null
        when(index){
            0->Fragments=homeFragments
            1->Fragments=messageFragment
            2->Fragments=EmptyFragment
            3->Fragments= videoFragment
            4->Fragments= userFragments

        }
        return Fragments!!;
    }

}