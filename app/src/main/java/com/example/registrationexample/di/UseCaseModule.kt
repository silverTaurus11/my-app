package com.example.registrationexample.di

import com.example.registrationexample.domain.usecase.news.NewsInteractor
import com.example.registrationexample.domain.usecase.news.NewsUseCase
import com.example.registrationexample.domain.usecase.user.UserInteractor
import com.example.registrationexample.domain.usecase.user.UserUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class UseCaseModule {
    @Binds
    abstract fun provideNewsUseCase(newsInteractor: NewsInteractor): NewsUseCase

    @Binds
    abstract fun provideUserUseCase(userInteractor: UserInteractor): UserUseCase
}