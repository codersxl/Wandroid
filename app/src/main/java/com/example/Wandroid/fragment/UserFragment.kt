package com.example.Wandroid.fragment
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
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.Wandroid.R
import com.example.Wandroid.adapter.UserAdapter
import com.example.Wandroid.mvp.comm.BaseFragment

import com.example.Wandroid.mvp.model.ChaptersModel
import com.example.Wandroid.mvp.prenster.UserPresanter
import com.example.Wandroid.mvp.view.UserView
import com.example.Wandroid.utils.LogUtils
import kotlinx.android.synthetic.main.fragment_user.*

class UserFragment : BaseFragment<UserView, UserPresanter>() ,UserView {


    override fun getLayout(): Int {
        return R.layout.fragment_user
    }

    override fun createPrenster(): UserPresanter {

        return UserPresanter()
    }

    override fun initView(rootView: View?) {
       // rootView.name.setText("zhangsan")
        //rootView.
        //name_tv.setText("zhsas")

        val userAdapter = UserAdapter(con);
        recyclerViewss.adapter=userAdapter
        val linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerViewss.layoutManager=linearLayoutManager

    }

    override fun initListner() {
        /**跳转到其他的页面
         *
         */
        arrow_right.setOnClickListener {
            
        }

    }

    override fun initData() {
        val showDatas = getPrenster()?.getShowDatas()
        //val showData = getPrenster()?.getShowData()

    }

    override fun <T> onSuccess(data: T) {
        val chaptersModel = data as ChaptersModel
        for (i in chaptersModel.data.indices){
            LogUtils.d(this,"${chaptersModel.data.get(i)}------------------------")
        }

        Log.e("----------------","00000000000000")
    }

    override fun onFailed(mes: String) {
        LogUtils.d(this,"${mes}------------------------")
    }

    override fun onlading() {

    }

    override fun onEmpty() {

    }
}