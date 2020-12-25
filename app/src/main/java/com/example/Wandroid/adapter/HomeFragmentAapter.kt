package com.example.Wandroid.adapter;

import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Wandroid.R
import com.example.Wandroid.mvp.model.SearchModel
import kotlinx.android.synthetic.main.search_item.view.*

/**
 *Copyright (C), 2015-2020, XXX有限公司
 * @ClassName: HomeFragmentAapter
 * @Description: java类作用描述
 * @Author: xueliang
 * @Date: 2020/11/12 0012 0:48
 *Description:
 *博客地址：https://blog.csdn.net/xueshao110?spm=1010.2135.3001.5113
 */
class HomeFragmentAapter(con: Context?) : RecyclerView.Adapter<HomeFragmentAapter.HomeFragmentViewHodler>() {

    private var mListener : ((Int , String) -> Unit)? = null
    fun setOnItemClickListener(mListener : (position : Int, item : String) -> Unit){
        this.mListener = mListener
    }

       //通过高价函数定义 监听事件
    private  var mLister:((postion:Int,message:String)->UInt)?=null;
    var mdatas = ArrayList<String>()
    fun setOnmLister(Lisner:(postion:Int,message:String) ->UInt){
               this.mLister=Lisner
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeFragmentViewHodler {
        return HomeFragmentViewHodler(
            LayoutInflater.from(parent.context).inflate(R.layout.search_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: HomeFragmentViewHodler, position: Int) {
        val get = mdatas.get(position)
        with(get){
            holder.itemView.search_title.setText(Html.fromHtml(get))
        }

        holder.itemView.setOnClickListener {
            itemClickListener?.onSearchItemClick(mdatas.get(position))
        }
        holder?.itemView?.setOnClickListener {
            mListener?.invoke(position, mdatas.get(position))
        }
    }


    override fun getItemCount(): Int {
        return if (mdatas.size > 0) mdatas.size else 0
    }

    fun updateData(datas: ArrayList<String>) {
        if (!mdatas.isEmpty()!!) {
            mdatas.clear()
        }
        mdatas = datas
        notifyDataSetChanged()
    }

    fun updateLoadData(datas: List<SearchModel.Data.DataX>) {

        mdatas.addAll(datas as ArrayList<String>)
        notifyDataSetChanged()
    }


    inner class HomeFragmentViewHodler(itemView: View) : RecyclerView.ViewHolder(itemView) {
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


