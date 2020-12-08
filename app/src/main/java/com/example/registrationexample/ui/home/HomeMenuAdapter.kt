package com.example.registrationexample.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.registrationexample.ui.data.NewsFragment
import com.example.registrationexample.ui.profile.ProfileInfoFragment

class HomeMenuAdapter(fragmentActivity: FragmentActivity):
    FragmentStateAdapter(fragmentActivity) {

    val homeMenuList by lazy { listOf(
        NewsFragment.newInstances(),
        ProfileInfoFragment.newInstances()
    ) }

    override fun getItemCount(): Int {
        return homeMenuList.size
    }

    override fun createFragment(position: Int): Fragment {
        return homeMenuList[position]
    }

    inline fun <reified T>getFragmentPosition(): Int{
        for(index in 0..this.homeMenuList.size){
            if(this.homeMenuList[index] is T){
                return index
            }
        }
        return 0
    }
}