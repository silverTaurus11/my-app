package com.example.registrationexample.ui.data


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.registrationexample.R
import com.example.registrationexample.data.source.model.NewsModel

class NewsRecyclerAdapter(private val newsViewHolderListener: NewsViewHolderListener): RecyclerView.Adapter<NewsViewHolder>() {
    private var articles : List<NewsModel> = arrayListOf()

    fun updateItems(articles: List<NewsModel>){
        this.articles = articles
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_data_item, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val data = articles[position]
        holder.bind(data)
        holder.itemView.setOnClickListener {
            newsViewHolderListener.onItemClickListener(data)
        }
    }
}

class NewsViewHolder(view: View): RecyclerView.ViewHolder(view){
    private val shortDescriptionLabel by lazy { view.findViewById<TextView>(R.id.news_short_description) }
    private val sourceLabel by lazy { view.findViewById<TextView>(R.id.news_source) }
    private val dateLabel by lazy { view.findViewById<TextView>(R.id.news_date) }
    private val imageSlider by lazy { view.findViewById<ImageView>(R.id.banner_image_view) }

    fun bind(articleItem: NewsModel) {
        shortDescriptionLabel.text = articleItem.shortDescription
        sourceLabel.text = articleItem.sources
        dateLabel.text = articleItem.date
        if(articleItem.imageSlider.isNotEmpty()){
            Glide.with(itemView).load(articleItem.imageSlider[0]).into(imageSlider)
        }
    }
}

interface NewsViewHolderListener{
    fun onItemClickListener(item: NewsModel)
}