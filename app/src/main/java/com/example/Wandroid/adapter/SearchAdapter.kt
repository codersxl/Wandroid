package com.example.Wandroid.adapter;

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Wandroid.R
import com.example.Wandroid.mvp.model.SearchModel
import com.example.Wandroid.ui.SearchActivity
import kotlinx.android.synthetic.main.search_item.view.*

/**
 *Copyright (C), 2015-2020, XXX有限公司
 * @ClassName: SearchAdapter
 * @Description: java类作用描述
 * @Author: xueliang
 * @Date: 2020/11/11 0011 15:13
 *Description:
 *博客地址：https://blog.csdn.net/xueshao110?spm=1010.2135.3001.5113
 */
class SearchAdapter(searchActivity: SearchActivity) :
    RecyclerView.Adapter<SearchAdapter.SearchViewHodler>() {


    var mdatas = ArrayList<SearchModel.Data.DataX>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHodler {
        return SearchViewHodler(
            LayoutInflater.from(parent.context).inflate(R.layout.search_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SearchViewHodler, position: Int) {
        holder.itemView.search_title.setText(Html.fromHtml(mdatas?.get(position)?.title))
        holder.itemView.setOnClickListener {
            itemClickListener?.onSearchItemClick(mdatas?.get(position)?.link)
        }

    }

    override fun getItemCount(): Int {
        return if (mdatas.size > 0) mdatas.size else 0
    }

    fun updateData(datas: List<SearchModel.Data.DataX>) {
        if (!mdatas?.isEmpty()!!) {
            mdatas?.clear()
        }
        mdatas = datas as ArrayList<SearchModel.Data.DataX>;
        notifyDataSetChanged()
    }

    fun updateLoadData(datas: List<SearchModel.Data.DataX>) {

        mdatas.addAll(datas as ArrayList<SearchModel.Data.DataX>)
        notifyDataSetChanged()
    }


    inner class SearchViewHodler(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.search_title)

    }

    fun dataClear() {
        if (!mdatas.isEmpty()) {
            mdatas.clear()
            notifyDataSetChanged()
        }
    }


    private var itemClickListener: OnSearchItemClickListener? = null

    fun setOnSearchItemClickListener(listener: OnSearchItemClickListener) {
        this.itemClickListener = listener
    }

    interface OnSearchItemClickListener {
        fun onSearchItemClick(link: String)
    }
}
