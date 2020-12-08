package com.example.registrationexample.domain.usecase.news

import androidx.lifecycle.LiveData
import com.example.registrationexample.data.source.model.NewsModel

interface NewsUseCase {
    fun getNews(): LiveData<List<NewsModel>>
}