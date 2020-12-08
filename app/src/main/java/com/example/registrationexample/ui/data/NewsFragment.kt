package com.example.registrationexample.ui.data

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.registrationexample.R
import com.example.registrationexample.data.source.model.NewsModel
import com.example.registrationexample.ui.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.news_data_fragment.*

@AndroidEntryPoint
class NewsFragment: Fragment() {

    companion object{
        fun newInstances() = NewsFragment()
    }

    private val newsViewModel: NewsViewModel by viewModels()
    private val newsRecyclerAdapter by lazy { NewsRecyclerAdapter(object : NewsViewHolderListener{
        override fun onItemClickListener(item: NewsModel) {
            startActivity(Intent(activity, DetailActivity::class.java).apply {
                putExtra(DetailActivity.DETAIL_DATA_INTENT_KEY, item)
            })
        }
    }) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.news_data_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        initNewsListObserver()
    }

    private fun initRecyclerView(){
        newsRecyclerView.layoutManager = LinearLayoutManager(activity)
        newsRecyclerView.adapter = newsRecyclerAdapter
    }

    private fun initNewsListObserver(){
        newsViewModel.newsList.observe(viewLifecycleOwner, Observer {
            if(it.isNotEmpty()){
                newsRecyclerAdapter.updateItems(it)
            }
        })
    }

}