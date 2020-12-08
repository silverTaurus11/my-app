package com.example.registrationexample.domain.usecase.user

import androidx.lifecycle.LiveData
import com.example.registrationexample.data.source.model.User

interface UserUseCase {
    fun saveUser(user: User)
    fun getUser(): LiveData<User?>
    fun deleteUser()
}