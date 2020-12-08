package com.example.registrationexample.data.source.model

data class User(val email: String, val password: String){
    var photoUrl: String?= ""
    var name: String?= ""
    var phoneNumber: String?= ""
    var sex: String?= ""
}