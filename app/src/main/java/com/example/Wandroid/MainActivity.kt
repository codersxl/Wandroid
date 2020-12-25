package com.example.Wandroid

/**
 *Copyright (C), 2015-2020, XXX有限公司
 * @ClassName: Test
 * @Description: java类作用描述
 * @Author: xueliang
 * @Date: 2020/11/8 0008 21:21
 *Description:
 *博客地址：https://blog.csdn.net/xueshao110?spm=1010.2135.3001.5113
 */

import TitlTab
import android.annotation.SuppressLint
import android.content.res.TypedArray
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.Wandroid.adapter.HomeApter
import com.example.Wandroid.mvp.comm.BaseActivity
import com.example.Wandroid.mvp.prenster.MainPrenster
import com.example.Wandroid.mvp.view.MainView
import com.example.Wandroid.utils.FragmentHelper
import com.explame.lib_comm.widget.UiLoading
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : BaseActivity<MainView, MainPrenster>(), MainView {

    private val fragments = ArrayList<Fragment>()
    private val tab = ArrayList<CustomTabEntity>()
    private var height: Int = 0;
    override fun initListner() {


        viewPagers.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                if (position == 2) {

                } else {
                    commtablayout.currentTab = position
                }


            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })
    }

    @SuppressLint("ResourceType")
    override fun initData() {

        getPrenster()?.let {
            it.ONSU()
        }

    }

    override fun createPrenster(): MainPrenster {
        return MainPrenster()
    }

    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun <T> onSuccess(data: T) {

       // uiLoading?.upDateUi(UiLoading.netstatus.Scuess)
        Log.d("------------", "$data   uuuuuuuuuuuuuuuuuuuuuu")
    }

    override fun onFailed(mes: String) {
        Log.d("------------", "$mes   uuuuuuuuuuuuuuuuuuuuuu")
    }

    override fun onlading() {

    }

    override fun onEmpty() {

    }

    override fun initView() {
        for (i in 0..4) {
            fragments.add(FragmentHelper.getFragment(i))
        }

        var selected: TypedArray? = null
        var unselected: TypedArray? = null
        try {
            val titles: Array<out String> = resources.getStringArray(R.array.title)
            selected = resources.obtainTypedArray(R.array.selected)
            unselected = resources.obtainTypedArray(R.array.unselected);
            for (i in titles.indices) {
                tab.add(TitlTab(titles[i], selected.getResourceId(i, 0), unselected.getResourceId(i, 0)))
            }
            commtablayout.setTabData(tab)
        } finally {
            selected?.recycle();
            unselected?.recycle()
        }


        val homeApter = HomeApter(supportFragmentManager, fragments)
        viewPagers.adapter = homeApter

        commtablayout.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {

                if (position != 2) {
                    viewPagers.setCurrentItem(position)
                }

                Log.e("---", "$position=========")
            }

            override fun onTabReselect(position: Int) {

            }

        })

    }

    /**
     * 双击退出
     */
    override fun onBackPressed() {
        //双击返回退出App
        if (System.currentTimeMillis() - lastTime > EXIT_TIME) {
            if (viewPagers.getCurrentItem() == 1) {
                viewPagers.setCurrentItem(0);
            } else {
                Toast.makeText(getApplicationContext(), "再按一次退出", Toast.LENGTH_SHORT).show();
                lastTime = System.currentTimeMillis();
            }
        } else {
            super.onBackPressed();
        }
    }

}