package com.example.registrationexample.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.registrationexample.R
import com.example.registrationexample.helper.Utils
import com.example.registrationexample.ui.home.HomeActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.profile_info_fragment.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFormValidationObserver()
        initUserDataObserver()
        registerButton.setOnClickListener {
            val email = editTextTextEmailAddress.text.toString()
            val password = editTextTextPassword.text.toString()
            mainViewModel.saveUser(email, password)
            hideKeyboard()
        }
    }

    private fun initFormValidationObserver(){
        mainViewModel.formValidation.observe(this, Observer {
            when(it){
                MainViewModel.Validation.EMAIL_INVALID -> editTextTextEmailAddress.error = "Harap masukkan nama Anda"
                MainViewModel.Validation.PASSWORD_INVALID ->
                    editTextTextPassword.error = "Password 6 digit harus berupa Huruf Besar, Huruf Kecil, Angka, dan Spesial Karakter"
                else -> return@Observer
            }
        })
    }

    private fun initUserDataObserver(){
        mainViewModel.user.observe(this, Observer {
            if(it != null){
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            }
        })
    }

    private fun hideKeyboard(){
        Utils.hideKeyboard(registerButton, this@MainActivity)
    }

}