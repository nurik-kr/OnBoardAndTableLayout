package com.example.onboardandtablelayout.Data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OnBoardModel(
    val image: Int,
    val title: String,
    val desc: String
) : Parcelable