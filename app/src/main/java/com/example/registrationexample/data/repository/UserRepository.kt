package com.example.registrationexample.data.repository

import androidx.lifecycle.LiveData
import com.example.registrationexample.data.source.local.SharePrefDataStore
import com.example.registrationexample.data.source.model.User
import com.example.registrationexample.domain.repository.IUserRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(private val sharePrefDataStore: SharePrefDataStore): IUserRepository {
    override fun saveUser(user: User) {
        sharePrefDataStore.saveMyProfile(user)
    }

    override fun getUser(): LiveData<User?> {
        return sharePrefDataStore.getMyProfile()
    }

    override fun deleteUser() {
        sharePrefDataStore.deleteMyProfile()
    }
}