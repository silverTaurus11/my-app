package com.example.registrationexample.di

import android.content.Context
import com.example.registrationexample.data.source.local.LocalDataStore
import com.example.registrationexample.data.source.local.SharePrefDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DataStoreModule {

    @Singleton
    @Provides
    fun provideLocalDataStore(): LocalDataStore = LocalDataStore.getInstance()

    @Singleton
    @Provides
    fun provideSharePrefDataStore(@ApplicationContext context: Context): SharePrefDataStore =
        SharePrefDataStore.getInstance(context)
}