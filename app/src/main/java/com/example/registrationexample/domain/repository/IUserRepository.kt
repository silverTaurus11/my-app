package com.example.registrationexample.domain.repository

import androidx.lifecycle.LiveData
import com.example.registrationexample.data.source.model.User

interface IUserRepository {
    fun saveUser(user: User)
    fun getUser(): LiveData<User?>
    fun deleteUser()
}