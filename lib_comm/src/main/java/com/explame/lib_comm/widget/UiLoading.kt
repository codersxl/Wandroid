package com.explame.lib_comm.widget

import android.content.Context
import android.os.Handler
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.explame.lib_network.R


/**
 * author : 一抹离愁
 * e-mail : coderxl@163.com
 * desc   :  动态切换网络状态
 * version: 1.0
 */
abstract class UiLoading : RelativeLayout {
    private var mLoding_View: View? = null
    private var mEmpty_View: View? = null
    private var mNone_View: View? = null
    private var mScuess_View: View? = null
    private var mErro_View: View? = null
   private  var handlers:Handler?=null
    //当前状态
    private var Currnt = netstatus.Loding

    constructor(context: Context) : super(context){
        init()
    }
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    enum class netstatus {
        None, Empty, Scuess, Loding, Erro
    }

    init {
        handlers=Handler()
    }

    /**
     * 从外部更改Ui
     */
    fun upDateUi(nets: netstatus) {
        Currnt = nets

        handlers?.post(Runnable { swiTchUi() })
    }

    private fun init() {
        swiTchUi()
    }

    private fun swiTchUi() {
        /**
         * 正在加载中的页面
         */
        if (mLoding_View == null) {
            mLoding_View = lodingView
            val params = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            addView(mLoding_View, params)
        }
        mLoding_View!!.visibility = if (Currnt == netstatus.Loding) VISIBLE else GONE
        if (mNone_View == null) {
            mNone_View = noneView
            val params = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            addView(mNone_View, params)
        }
        mNone_View!!.visibility = if (Currnt == netstatus.None) VISIBLE else GONE
        /**
         * 加载成功
         *
         * private View mEmpty_View = null;
         * private View mNone_View = null;
         * private View  = null;
         * private View  = null;
         *
         */
        if (mErro_View == null) {
            mErro_View = erroView
            val btn = mErro_View!!.findViewById<View>(R.id.onclick_items) as LinearLayout
            btn.setOnClickListener {
                if (onErroClick != null) {
                    onErroClick!!.onItemClick()
                }
            }
            addView(mErro_View)
        }
        mErro_View!!.visibility = if (Currnt == netstatus.Erro) VISIBLE else GONE
        /**
         * 加载成功为空
         */
        if (mEmpty_View == null) {
            mEmpty_View = emptyView
            addView(mEmpty_View)
        }
        mEmpty_View!!.visibility = if (Currnt == netstatus.Empty) VISIBLE else GONE
        /**
         * 加载成功
         */
        if (mScuess_View == null) {
            mScuess_View = getScuessView()
            val params = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            addView(mScuess_View,params)
        }
        mScuess_View!!.visibility = if (Currnt == netstatus.Scuess) VISIBLE else GONE
    }

    @JvmName("setOnErroClick1")
    fun setOnErroClick(onErroClick: OnErroClick?) {
        this.onErroClick = onErroClick
    }

    /**
     * 创建对外的接口
     *
     * @param container
     * @return
     */
    var onErroClick: OnErroClick? = null

    interface OnErroClick {
        fun onItemClick()
    }

    abstract fun getScuessView(): View
    private val emptyView: View
        private get() = LayoutInflater.from(this.context).inflate(R.layout.fragment_empty_view, this, false)
    private val erroView: View
        private get() = LayoutInflater.from(this.context).inflate(R.layout.fragment_erro_view, this, false)
    private val noneView: View
        private get() = LayoutInflater.from(this.context).inflate(R.layout.fragment_none_view, this, false)
    private val lodingView: View
        private get() = LayoutInflater.from(this.context).inflate(R.layout.fragment_loading_view, this, false)

    init {
        init()
    }
}