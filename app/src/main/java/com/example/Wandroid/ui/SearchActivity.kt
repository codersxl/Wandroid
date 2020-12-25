package com.example.Wandroid.ui

import android.content.Intent
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.Wandroid.R
import com.example.Wandroid.adapter.SearchAdapter
import com.explame.lib_network.http.Const
import com.example.Wandroid.mvp.comm.BaseActivity
import com.example.Wandroid.mvp.model.HotWordModel
import com.example.Wandroid.mvp.model.SearchModel
import com.example.Wandroid.mvp.prenster.HotKeyPrenster
import com.example.Wandroid.mvp.prenster.SearchPrenster
import com.example.Wandroid.mvp.view.HotView
import com.example.Wandroid.mvp.view.SearchView
import com.example.Wandroid.room.DataBaseDao
import com.example.Wandroid.room.WorkEntity
import com.example.Wandroid.room.WorkHelp
import com.example.Wandroid.utils.CachHotUtils
import com.example.Wandroid.utils.FlowTextLayout
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout
import com.lcodecore.tkrefreshlayout.footer.LoadingView
import kotlinx.android.synthetic.main.activity_search.*


class SearchActivity : BaseActivity<SearchView, SearchPrenster>(), SearchView, TextWatcher,
    HotView {
    private var isSccuess: Boolean = true
    private var Text: String? = null
    lateinit var searchAdapter: SearchAdapter
    private var currntText: String? = null
    private var workDataBase: DataBaseDao? = null
    var contentList: ArrayList<String> = ArrayList()
    var history_text: ArrayList<String> = ArrayList()
    private var isshow: Boolean = false
    override fun initView() {
        searchAdapter = SearchAdapter(this);
        recy_reslt.adapter = searchAdapter
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recy_reslt.layoutManager = linearLayoutManager

    }

    override fun initListner() {

        search_text.addTextChangedListener(this)
        btn_search.setOnClickListener {
            Text = search_text.text.toString()
            currntText = Text
            if (TextUtils.isEmpty(Text)) {
                Toast.makeText(applicationContext, "不能为空", Toast.LENGTH_SHORT).show()
            } else {

                Text?.let { it1 -> getPrenster()!!.search(it1, 0) }
                var en = WorkEntity();
                en.name = Text.toString()
                workDataBase?.inserts(en)
            }
        }
        /**
         * clear
         */
        detele.setOnClickListener {
            search_text.text = null
        }

        /**
         * search_hotword
         *
         */
        search_hotword.setClickListener(object : FlowTextLayout.ItemClickListener {
            override fun onItemClick(texts: String) {
                search_text.setText(texts);
            }
        })


        /**
         * 历史监听
         *
         */
        histroy_hotword.setClickListener(object : FlowTextLayout.ItemClickListener {
            override fun onItemClick(text: String) {
                search_text.setText(text);
            }
        })

        searchAdapter.setOnSearchItemClickListener(object :
            SearchAdapter.OnSearchItemClickListener {
            override fun onSearchItemClick(link: String) {
                val intent = Intent(con, SearchDetilsActivity::class.java);
                intent.putExtra(Const.URL, link)
                startActivity(intent)
            }

        })
        //删除历史

        del_histery.setOnClickListener {
            history_text.clear()
            workDataBase?.deteAll()
            histroy_hotword.setTextContents(history_text)
            del_histery.visibility = View.GONE
        }

        //上拉加载底部view设置
        tkrefreshlayout.setEnableRefresh(false)
        val loadingView = LoadingView(this)
        tkrefreshlayout.setBottomView(loadingView)
        tkrefreshlayout.setOnRefreshListener(object : RefreshListenerAdapter() {


            override fun onLoadMore(refreshLayout: TwinklingRefreshLayout?) {
                super.onLoadMore(refreshLayout)
                getPrenster()?.let {
                    it.getonLoadMore(currntText!!)
                }
            }
        })
    }


    override fun initData() {
        workDataBase = WorkHelp.getInsatnce(this)?.dao

        addHistory()
    }

    /**
     * 查询历史记录
     */
    fun addHistory() {
        val querys: MutableList<WorkEntity>? = workDataBase?.Querys()
        for (i in querys?.indices!!) {
            history_text.add(querys?.get(i).name)
        }
        histroy_hotword.setTextContents(history_text)
    }

    override fun createPrenster() = SearchPrenster()

    override fun getLayout() = R.layout.activity_search
    override fun <T> onHotSccuess(data: T) {
        val hotWordModel = data as HotWordModel
        val data1 = hotWordModel.data
        for (i in data1.indices) {
            contentList.add(data1.get(i).name)
            CachHotUtils.addkey(data1.get(i).name)
        }
        search_hotword.setTextContents(contentList)
    }

    override fun onHotFailed(mes: String) {

    }

    override fun <T> onSuccess(data: T) {

        search_hotword.visibility = View.GONE
        val searchModel = data as SearchModel
        // Log.e("000000000000000","$searchModel")
        val datas: MutableList<SearchModel.Data.DataX> =
            searchModel.data.datas as MutableList<SearchModel.Data.DataX>
        searchAdapter.updateData(datas)
    }

    override fun onFailed(mes: String) {

    }

    override fun onlading() {

    }

    override fun onResume() {
        super.onResume()
        val hotKeyPrenster = HotKeyPrenster()
        hotKeyPrenster.bindView(this)
        if (CachHotUtils.size() > 0) {
            search_hotword.setTextContents(CachHotUtils.getValue())

        } else {
            hotKeyPrenster.getHotWord()
        }


    }


    override fun <T> onLoadMore(data: T) {
        search_hotword.visibility = View.GONE
        tkrefreshlayout.finishLoadmore()
        isSccuess = true
        val searchModel = data as SearchModel

        val datas: MutableList<SearchModel.Data.DataX> =
            searchModel.data.datas as MutableList<SearchModel.Data.DataX>
        searchAdapter.updateLoadData(datas)
    }

    override fun onLoadMoreErro(mes: String) {

        tkrefreshlayout.finishLoadmore()
    }

    override fun onEmpty() {
        searchAdapter.notifyDataSetChanged()
        Toast.makeText(applicationContext, "没有跟多了", Toast.LENGTH_SHORT).show()
        tkrefreshlayout.finishLoadmore()
        tkrefreshlayout.setEnableLoadmore(false)
    }

    override fun onLoadMoreEmpty() {
        searchAdapter.notifyDataSetChanged()
        Toast.makeText(applicationContext, "没有跟多了", Toast.LENGTH_SHORT).show()
        tkrefreshlayout.finishLoadmore()
        tkrefreshlayout.setEnableLoadmore(false)
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        if (!TextUtils.isEmpty(s)) {
            isshow = false;
            showLayout(s)
        } else {
            addHistory()
            isshow = true;
            showLayout(s)
        }

    }

    override fun afterTextChanged(s: Editable?) {

    }

    fun showLayout(s: CharSequence?) {
        if (isshow) {
            //gone
            hot.visibility = View.VISIBLE
            detele.visibility = View.GONE
            histroy_layout.visibility = View.VISIBLE
            search_hotword.setTextContents(CachHotUtils.getValue())
            search_hotword.visibility = View.VISIBLE
            histroy_hotword.visibility = View.VISIBLE
            searchAdapter.dataClear()
        } else {
            detele.visibility = View.VISIBLE

            //go
            getPrenster()?.let {
                it.search(s.toString(), 0)
            }
            histroy_layout.visibility = View.GONE
            hot.visibility = View.GONE
            histroy_hotword.visibility = View.GONE
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        finish()
    }
}