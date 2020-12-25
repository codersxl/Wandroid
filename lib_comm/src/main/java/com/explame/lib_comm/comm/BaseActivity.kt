package com.example.Wandroid.mvp.comm
/**
 *Copyright (C), 2015-2020, XXX有限公司
 * @ClassName: Test
 * @Description: java类作用描述
 * @Author: xueliang
 * @Date: 2020/11/8 0008 21:21
 *Description:
 *博客地址：https://blog.csdn.net/xueshao110?spm=1010.2135.3001.5113
 */
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.explame.lib_comm.widget.UiLoading


abstract class BaseActivity<V, P : BasePrenster<V>> : FragmentActivity() {
    private var mPrenster:P?=null;
    private var morePrenster:P?=null;
    protected var uiLoading: UiLoading?=null
    /** 上次点击返回键时间  */
    protected var lastTime: Long = 0
    protected  var con:Context?=null
    /** 连续按返回键退出时间  */
    protected val EXIT_TIME = 2000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // StutasBarUtils.setStatusBar(this, 2, R.color.red)
        setContentView(getLayout())
        con=this
        if(mPrenster==null){
           mPrenster=createPrenster() as P;
         }
         mPrenster?.bindView(this as V)

         initView()
         initData();
         initListner();
    }



    abstract fun initView()

    abstract fun initListner()

    abstract fun initData()

    abstract fun createPrenster(): P

    abstract fun getLayout(): Int

    override fun onDestroy() {
        super.onDestroy()

      mPrenster.let {
          it?.unbindView()
      }
      mPrenster=null;
    }

    open fun getPrenster()=mPrenster

    /**
     * Toast处理
     *
     */
    fun Toasts(msg:String){
        runOnUiThread {
            Toast.makeText(applicationContext, "$msg", Toast.LENGTH_SHORT).show()
        }
    }
    
}