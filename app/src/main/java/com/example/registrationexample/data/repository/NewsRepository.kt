package com.example.registrationexample.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.registrationexample.data.source.local.LocalDataStore
import com.example.registrationexample.domain.repository.INewsRepository
import com.example.registrationexample.data.source.model.NewsModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepository @Inject constructor(private val localDataStore: LocalDataStore): INewsRepository {

    override fun getNews(): LiveData<List<NewsModel>> {
        val mutableData = MutableLiveData<List<NewsModel>>()
        mutableData.value = localDataStore.getDummyData()
        return mutableData
    }
}