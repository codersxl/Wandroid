package com.example.Wandroid.mvp.model;

/**
 *Copyright (C), 2015-2020, XXX有限公司
 * @ClassName: HotWordModel
 * @Description: java类作用描述
 * @Author: xueliang
 * @Date: 2020/11/11 0011 17:40
 *Description:
 *博客地址：https://blog.csdn.net/xueshao110?spm=1010.2135.3001.5113
 */
data class HotWordModel(
    val `data`: List<Data>,
    val errorCode: Int,
    val errorMsg: String
){
    data class Data(
        val id: Int,
        val link: String,
        val name: String,
        val order: Int,
        val visible: Int
    )
}

