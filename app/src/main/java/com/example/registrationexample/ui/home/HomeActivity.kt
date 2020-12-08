package com.example.registrationexample.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import com.example.registrationexample.R
import com.example.registrationexample.ui.data.NewsFragment
import com.example.registrationexample.ui.login.MainActivity
import com.example.registrationexample.ui.login.MainViewModel
import com.example.registrationexample.ui.profile.ProfileInfoFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_home.*

@AndroidEntryPoint
class HomeActivity: FragmentActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    private val homeMenuAdapter by lazy { HomeMenuAdapter(this) }
    private val bottomNavigationListener by lazy { BottomNavigationView.OnNavigationItemSelectedListener {item ->
        when(item.itemId){
            R.id.info_navigation -> homeViewPager.setCurrentItem(homeMenuAdapter.getFragmentPosition<ProfileInfoFragment>(), true)
            else-> homeViewPager.setCurrentItem(homeMenuAdapter.getFragmentPosition<NewsFragment>(), true)
        }
        true
    } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        toolbar.setOnMenuItemClickListener {
            if(it.itemId == R.id.logout_menu){
                mainViewModel.deleteUser()
            }
            false
        }
        initViewPager()
        navigation.setOnNavigationItemSelectedListener(bottomNavigationListener)
        initUserOberserver()
    }

    private fun initViewPager(){
        homeViewPager.adapter = homeMenuAdapter
        homeViewPager.offscreenPageLimit = homeMenuAdapter.itemCount
        homeViewPager.isUserInputEnabled = false
    }

    private fun initUserOberserver(){
        mainViewModel.user.observe(this, Observer {
            if(it == null){
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        })
    }
}