package com.example.registrationexample.domain.usecase.user

import androidx.lifecycle.LiveData
import com.example.registrationexample.data.source.model.User
import com.example.registrationexample.domain.repository.IUserRepository
import javax.inject.Inject

class UserInteractor @Inject constructor(private val userRepository: IUserRepository): UserUseCase {
    override fun saveUser(user: User) {
        userRepository.saveUser(user)
    }

    override fun getUser(): LiveData<User?> {
        return userRepository.getUser()
    }

    override fun deleteUser() {
        return userRepository.deleteUser()
    }
}