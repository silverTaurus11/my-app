package com.example.registrationexample.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.registrationexample.R
import com.smarteist.autoimageslider.SliderViewAdapter

class SliderImageAdapter(private val imageUrls: List<String>): SliderViewAdapter<SliderImageAdapter.SliderViewHolder>() {

    class SliderViewHolder(view: View): SliderViewAdapter.ViewHolder(view){
        private val imageDetailView by lazy { view.findViewById(R.id.imageDetailView) as ImageView }

        fun bind(url: String){
            Glide.with(itemView).load(url).fitCenter().into(imageDetailView)
        }
    }

    override fun getCount(): Int = imageUrls.size

    override fun onCreateViewHolder(parent: ViewGroup): SliderViewHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.image_slider_item, null);
        return SliderViewHolder(inflate)
    }

    override fun onBindViewHolder(viewHolder: SliderViewHolder?, position: Int) {
        viewHolder?.bind(imageUrls[position])
    }
}