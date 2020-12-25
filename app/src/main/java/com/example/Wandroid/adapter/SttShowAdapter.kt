package com.example.Wandroid.adapter;

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.Wandroid.R
import com.example.Wandroid.utils.Tab

/**
 *Copyright (C), 2015-2020, XXX有限公司
 * @ClassName: SttShowAdapter
 * @Description: java类作用描述
 * @Author: xueliang
 * @Date: 2020/11/9 0009 15:26
 *Description:
 *博客地址：https://blog.csdn.net/xueshao110?spm=1010.2135.3001.5113
 */
class SttShowAdapter(var con: Context?, var TabList: MutableList<Tab>) : RecyclerView.Adapter<SttShowAdapter.SttShowHoders>() {
    private var items: ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            SttShowHoders(LayoutInflater.from(parent.context).inflate(R.layout.fragment_show_item, parent, false))
    override fun onBindViewHolder(holder: SttShowHoders, position: Int) {
        holder.textView.setText(TabList.get(position).name)
        Glide.with(con).load(TabList.get(position).imag).into(holder.image_ico)
//        holder.itemView.parent.requestDisallowInterceptTouchEvent(true)
        holder.itemView.setOnClickListener {
            items?.let {
                it.onclick(position)
            }
        }

    }


    override fun getItemCount(): Int {
        return if (TabList.size > 0) TabList.size else 0
    }


    inner class SttShowHoders(view: View) : RecyclerView.ViewHolder(view) {
        var textView: TextView = view.findViewById(R.id.titless)
        var image_ico: ImageView = view.findViewById(R.id.image_ico)

    }

    fun setOnclick(itemClick: ItemClick) {
        this.items = itemClick
    }

    interface ItemClick {
        fun onclick(postion: Int)
    }
}

