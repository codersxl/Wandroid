package com.example.Wandroid.adapter;

import android.content.Context
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.Wandroid.R
import com.example.Wandroid.utils.Tab

/**
 *Copyright (C), 2015-2020, XXX有限公司
 * @ClassName: UserAdapter
 * @Description: java类作用描述
 * @Author: xueliang
 * @Date: 2020/11/8 0008 23:21
 *Description:startActivityS
 *博客地址：https://blog.csdn.net/xueshao110?spm=1010.2135.3001.5113
 */
class UserAdapter(var con: Context?) : RecyclerView.Adapter<UserAdapter.UserViewsHoders>() {

    private var onItemClickListener: OnChildClickListener? = null
    private val listOf by lazy {
        listOf<String>("发现", "常用");
    }
    private var TabList: MutableList<Tab> = mutableListOf()


    init {
        val titles: Array<out String> = con?.resources?.getStringArray(R.array.sett_title) as Array<out String>
        val selected = con!!.resources.obtainTypedArray(R.array.set_ico);
        for (i in titles.indices) {
            TabList.add(Tab(titles.get(i), selected.getResourceId(i, 0)))
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            UserViewsHoders(
                    LayoutInflater.from(parent.context).inflate(
                            R.layout.fragment_user_item,
                            parent,
                            false
                    )
            )


    override fun onBindViewHolder(holder: UserViewsHoders, position: Int) {

        holder.texRecyclerView.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                return holder.itemView.onTouchEvent(event)
            }
        })

        holder.textView.setText(listOf.get(position))


        val sttShowAdapter = SttShowAdapter(con, TabList);

        val gridLayoutManager = GridLayoutManager(con, 3);

        holder.texRecyclerView.layoutManager = gridLayoutManager
        holder.texRecyclerView.adapter = sttShowAdapter
        holder.texRecyclerView.isNestedScrollingEnabled = false
        sttShowAdapter.setOnclick(object : SttShowAdapter.ItemClick {
            override fun onclick(postion: Int) {
                Toast.makeText(con, "$position", Toast.LENGTH_SHORT).show()
            }

        })

    }


    override fun getItemCount(): Int {
        return if (listOf.size > 0) listOf.size else 0
    }


    inner class UserViewsHoders(view: View) : RecyclerView.ViewHolder(view) {
        var textView: TextView = view.findViewById(R.id.titles)
        val texRecyclerView: RecyclerView = view.findViewById(R.id.titles_rcyview)
    }

    fun setOnChildPositionListener(onItemClickListener: OnChildClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    interface OnChildClickListener {
        //成功的方法传 int 的索引
        fun success(index: Int)
    }

}
