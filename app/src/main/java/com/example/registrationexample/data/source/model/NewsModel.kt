package com.example.registrationexample.data.source.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewsModel(
    val shortDescription: String,
    val sources: String,
    val date: String,
    val imageSlider: List<String>): Parcelable