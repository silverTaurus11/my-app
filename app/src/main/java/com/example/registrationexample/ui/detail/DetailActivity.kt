package com.example.registrationexample.ui.detail

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.registrationexample.R
import com.example.registrationexample.data.source.model.NewsModel
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import kotlinx.android.synthetic.main.activity_news_detail.*

class DetailActivity: AppCompatActivity() {

    companion object{
        const val DETAIL_DATA_INTENT_KEY = "detailDataKey"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)
        val item = intent.getParcelableExtra<NewsModel>(DETAIL_DATA_INTENT_KEY)
        item?.apply {
            news_short_description.text = shortDescription
            news_source.text = sources
            news_date.text = date
            if(imageSlider.isNotEmpty()){
                setImageSlider(imageSlider)
            }
        }
    }

    private fun setImageSlider(urlList: List<String>){
        imageSlider.setSliderAdapter(SliderImageAdapter(urlList))
        imageSlider.setIndicatorAnimation(IndicatorAnimationType.WORM)
        imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        imageSlider.autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH;
        imageSlider.indicatorSelectedColor = Color.WHITE
        imageSlider.indicatorUnselectedColor = Color.GRAY
        imageSlider.scrollTimeInSec = 2
        imageSlider.startAutoCycle()
    }
}