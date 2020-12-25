package com.example.Wandroid.ui

import com.example.Wandroid.R
import com.example.Wandroid.mvp.comm.BaseActivity
import com.example.Wandroid.mvp.prenster.UserSttingPrenster
import com.example.Wandroid.mvp.view.UserSttingView

class UserSettingActivity : BaseActivity<UserSttingView, UserSttingPrenster>() {


    override fun initView() {

    }

    override fun initListner() {

    }

    override fun initData() {

    }

    override fun createPrenster(): UserSttingPrenster {
         return  UserSttingPrenster()
    }

    override fun getLayout()=R.layout.activity_user_setting
}