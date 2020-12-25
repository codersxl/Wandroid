package com.example.Wandroid.mvp.model;

/**
 *Copyright (C), 2015-2020, XXX有限公司
 * @ClassName: ChaptersModel
 * @Description: java类作用描述
 * @Author: xueliang
 * @Date: 2020/11/9 0009 14:07
 *Description:
 *博客地址：https://blog.csdn.net/xueshao110?spm=1010.2135.3001.5113
 */
 data class ChaptersModel(
    val `data`: List<Data>,
    val errorCode: Int,
    val errorMsg: String
)

data class Data(
    val children: List<Any>,
    val courseId: Int,
    val id: Int,
    val name: String,
    val order: Int,
    val parentChapterId: Int,
    val userControlSetTop: Boolean,
    val visible: Int
)