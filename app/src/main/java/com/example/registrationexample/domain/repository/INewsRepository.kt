package com.example.registrationexample.domain.repository

import androidx.lifecycle.LiveData
import com.example.registrationexample.data.source.model.NewsModel

interface INewsRepository {
    fun getNews(): LiveData<List<NewsModel>>
}