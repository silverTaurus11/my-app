package com.example.registrationexample.ui.login

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.registrationexample.data.repository.UserRepository
import com.example.registrationexample.data.source.model.User
import com.example.registrationexample.helper.Utils

class MainViewModel @ViewModelInject constructor(private val userRepository: UserRepository): ViewModel() {
    enum class Validation{
        EMAIL_INVALID,
        PASSWORD_INVALID,
        NONE
    }

    val user by lazy { userRepository.getUser() }
    val formValidation = MutableLiveData<Validation>()

    init {
        formValidation.value = Validation.NONE
    }

    fun saveUser(email: String, password: String){
        doFormValidation(email, password).also {
            if(it){
                userRepository.saveUser(User(email, password))
            }
        }
    }

    fun deleteUser(){
        userRepository.deleteUser()
    }

    private fun doFormValidation(email: String, password: String): Boolean{
        val isEmailValid = Utils.isEmailValid(email)
        if(!isEmailValid) formValidation.value = Validation.EMAIL_INVALID
        val isPasswordValid = Utils.isPasswordValid(password)
        if(!isPasswordValid) formValidation.value = Validation.PASSWORD_INVALID
        return isEmailValid && isPasswordValid
    }
}