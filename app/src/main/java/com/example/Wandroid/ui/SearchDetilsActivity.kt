package com.example.Wandroid.ui

import android.graphics.Bitmap
import android.view.KeyEvent

import android.webkit.WebResourceRequest
import android.webkit.WebView


import android.widget.LinearLayout
import android.widget.TextView
import com.example.Wandroid.R
import com.explame.lib_network.http.Const
import com.example.Wandroid.mvp.comm.BaseActivity
import com.example.Wandroid.mvp.prenster.SearchDetilsPrenster
import com.example.Wandroid.mvp.view.SearchDetilsView
import com.just.agentweb.AgentWeb
import com.just.agentweb.DefaultWebClient
import com.just.agentweb.WebChromeClient
import com.just.agentweb.WebViewClient


import kotlinx.android.synthetic.main.activity_search_detils.*

class SearchDetilsActivity : BaseActivity<SearchDetilsView,SearchDetilsPrenster>() {
    private var mAgentWeb: AgentWeb? = null
    private var titleView: TextView? = null
    override fun initView() {
        val url = intent.extras?.getString(Const.URL) ?: return
        val p = System.currentTimeMillis()
        mAgentWeb = AgentWeb.with(this)
            .setAgentWebParent(line_layout, LinearLayout.LayoutParams(-1, -1))
            .useDefaultIndicator()
            .setWebChromeClient(mWebChromeClient)
            .setWebViewClient(mWebViewClient)
            .setMainFrameErrorView(R.layout.agentweb_error_page, -1)
            .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)
            //打开其他应用时，弹窗咨询用户是否前往其他应用
            .setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.ASK)
            //拦截找不到相关页面的Scheme
            .interceptUnkownUrl()
            .createAgentWeb()
            .go(url)


        val n = System.currentTimeMillis()
    }

    override fun initListner() {

    }

    override fun initData() {

    }

    override fun createPrenster()=SearchDetilsPrenster()

    override fun getLayout()= R.layout.activity_search_detils
    private val mWebViewClient = object : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            return super.shouldOverrideUrlLoading(view, request)
        }

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            //do you  work

        }
    }

    private val mWebChromeClient = object : WebChromeClient() {
        override fun onReceivedTitle(view: WebView, title: String) {
            super.onReceivedTitle(view, title)
            titleView?.text = title
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        return if (mAgentWeb?.handleKeyEvent(keyCode, event) == true) {
            true
        } else super.onKeyDown(keyCode, event)
    }

    override fun onPause() {
        mAgentWeb?.getWebLifeCycle()?.onPause()
        super.onPause()

    }

    override fun onResume() {
        mAgentWeb?.getWebLifeCycle()?.onResume()
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        mAgentWeb?.getWebLifeCycle()?.onDestroy()
    }
}


