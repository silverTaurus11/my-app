package com.example.registrationexample.data.source.local

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import com.example.registrationexample.data.source.SharedPreferenceLiveData
import com.example.registrationexample.data.source.model.User
import com.google.gson.Gson

class SharePrefDataStore(private val context: Context, private val gson: Gson) {
    private val mainSharePref: SharedPreferences by lazy{context.getSharedPreferences(
        MAIN_SHARED_PREF_DATA_STORE, Context.MODE_PRIVATE)}

    companion object {
        const val MAIN_SHARED_PREF_DATA_STORE = "mainSharedPref"
        const val MY_PROFILE_KEY = "myProfileKey"
        @Volatile
        private var instance: SharePrefDataStore? = null

        fun getInstance(context: Context): SharePrefDataStore =
            instance ?: synchronized(this) {
                instance ?: SharePrefDataStore(context, Gson())
            }
    }

    fun saveMyProfile(user: User){
        mainSharePref.edit().putString(MY_PROFILE_KEY, gson.toJson(user)).apply()
    }

    fun deleteMyProfile(){
        mainSharePref.edit().putString(MY_PROFILE_KEY, "").apply()
    }

    fun getMyProfile(): LiveData<User?>{
        return object : SharedPreferenceLiveData<User?>(mainSharePref, MY_PROFILE_KEY, null){
            override fun getValueFromPreferences(key: String?, defValue: User?): User? {
                val dataString = sharedPrefs.getString(MY_PROFILE_KEY, "")
                if(!dataString.isNullOrEmpty()){
                    return gson.fromJson(dataString, User::class.java).apply {
                        name = "Gayuh Nurul Huda"
                        sex = "Male"
                        phoneNumber = "+6285771953079"
                        photoUrl = "https://media-exp1.licdn.com/dms/image/C5603AQFXRgnO7ebYiw/profile-displayphoto-shrink_100_100/0?e=1613001600&v=beta&t=q3fBN3a5ZQY2UIg6UbDTYodR33Bzr_Nfc1tOXqDHxwo"
                    }
                }
                return null
            }
        }
    }
}