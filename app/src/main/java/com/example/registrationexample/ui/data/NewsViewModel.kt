package com.example.registrationexample.ui.data

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.registrationexample.data.repository.NewsRepository

class NewsViewModel @ViewModelInject constructor(private val newsRepository: NewsRepository): ViewModel() {
    val newsList by lazy { newsRepository.getNews() }
}