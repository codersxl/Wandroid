package com.example.Wandroid.Test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.Wandroid.R
import kotlinx.android.synthetic.main.activity_test2.*

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test2)
        btn_loginssssssssss.setOnClickListener {
            RetrofitFactory.instance.sendRequset(this,RetrofitFactory.instance.getSevers(ApiNet::class.java).Logins(et_username.text.toString(),et_password.text.toString()),object :Back<BaseBen<LoginBen>>{
                override fun onSuccess(data: BaseBen<LoginBen>) {

                }

                override fun onFailed(erro: String) {

                }

            })


        }
    }
}


