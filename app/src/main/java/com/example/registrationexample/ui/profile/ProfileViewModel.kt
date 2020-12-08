package com.example.registrationexample.ui.profile

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.registrationexample.domain.usecase.user.UserUseCase

class ProfileViewModel @ViewModelInject constructor(private val userUseCase: UserUseCase): ViewModel() {
    val user by lazy { userUseCase.getUser() }
}