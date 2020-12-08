package com.example.registrationexample.domain.usecase.news

import androidx.lifecycle.LiveData
import com.example.registrationexample.domain.repository.INewsRepository
import com.example.registrationexample.data.source.model.NewsModel
import javax.inject.Inject

class NewsInteractor @Inject constructor(private val newsRepository: INewsRepository): NewsUseCase {

    override fun getNews(): LiveData<List<NewsModel>> {
        return newsRepository.getNews()
    }

}