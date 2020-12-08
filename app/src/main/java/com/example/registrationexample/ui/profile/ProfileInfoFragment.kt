package com.example.registrationexample.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.registrationexample.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.profile_info_fragment.*

@AndroidEntryPoint
class ProfileInfoFragment: Fragment() {

    companion object{
        fun newInstances() = ProfileInfoFragment()
    }

    private val profileViewModel: ProfileViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.profile_info_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        profileViewModel.user.observe(viewLifecycleOwner, Observer {
            if(it != null){
                nameFieldTextView.text = it.name
                emailFieldTextView.text = it.email
                sexFieldTextView.text = it.sex
                phoneNumberFieldTextView.text = it.phoneNumber
                Glide.with(this).load(it.photoUrl).into(photoProfileImageView)
            }
        })
    }
}