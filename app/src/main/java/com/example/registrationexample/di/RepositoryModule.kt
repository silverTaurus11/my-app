package com.example.registrationexample.di

import com.example.registrationexample.data.repository.NewsRepository
import com.example.registrationexample.data.repository.UserRepository
import com.example.registrationexample.domain.repository.INewsRepository
import com.example.registrationexample.domain.repository.IUserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideNewsRepository(newsRepository: NewsRepository): INewsRepository

    @Binds
    abstract fun provideUserRepository(userRepository: UserRepository): IUserRepository
}