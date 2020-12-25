package com.example.Wandroid.ui

/**
 *Copyright (C), 2015-2020, XXX有限公司
 * @ClassName: Test
 * @Description: java类作用描述
 * @Author: xueliang
 * @Date: 2020/11/8 0008 21:21
 *Description:
 *博客地址：https://blog.csdn.net/xueshao110?spm=1010.2135.3001.5113
 */
import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import com.example.Wandroid.MainActivity
import com.example.Wandroid.R
import com.example.Wandroid.mvp.comm.BaseActivity
import com.example.Wandroid.mvp.model.LoginModel
import com.example.Wandroid.mvp.prenster.LoginPrenster
import com.example.Wandroid.mvp.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity<LoginView, LoginPrenster>(), TextWatcher, LoginView {
    private var edit_account: String? = null
    private var edit_pwd: String? = null
    override fun initView() {


    }

    override fun initListner() {
        et_account.addTextChangedListener(this)
        et_pwd.addTextChangedListener(this)
        btn_login.setOnClickListener {

            edit_account?.let { it1 -> edit_pwd?.let { it2 -> getPrenster()?.Login(it1, it2) } }
        }
    }

    override fun initData() {

    }

    override fun createPrenster(): LoginPrenster {
        return LoginPrenster()
    }

    override fun getLayout(): Int {
        return R.layout.activity_login
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        edit_account = et_account.text.toString();
        edit_pwd = et_pwd.text.toString();
        if (edit_account!!.isNotEmpty() && edit_pwd!!.isNotEmpty()) {

            btn_login.isEnabled = true
        } else {
            btn_login.isEnabled = false
        }
    }

    override fun afterTextChanged(s: Editable?) {

    }

    override fun <T> onSuccess(data: T) {
        var Loginmodels = data as LoginModel
        val inetnt = Intent()
        intent.setClass(this, MainActivity::class.java)
        startActivity(intent)
        //Log.d("--","${}")
    }


    override fun onFailed(mes: String) {
        Log.d("--", "$mes")
    }

    override fun onlading() {

    }

    override fun onEmpty() {

    }
}