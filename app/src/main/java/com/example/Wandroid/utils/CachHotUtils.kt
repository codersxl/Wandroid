package com.example.Wandroid.utils;

/**
 *Copyright (C), 2015-2020, XXX有限公司
 * @ClassName: CachHotUtils
 * @Description: java类作用描述
 * @Author: xueliang
 * @Date: 2020/11/11 0011 19:26
 *Description:
 *博客地址：https://blog.csdn.net/xueshao110?spm=1010.2135.3001.5113
 */

object CachHotUtils {

    /**
     * 缓存热词
     *
     */


    var mdatas=ArrayList<String>()

    fun addkey(key:String){
      mdatas.add(key)
    }
    fun getValue():ArrayList<String>{
        return mdatas
    }

    fun size():Int{
        return mdatas.size
    }
}
