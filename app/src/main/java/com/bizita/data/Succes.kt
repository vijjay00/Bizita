package com.bizita.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Succes (
    val address: String,
    val category: String,
    val categoryid: String,
    val contact: String,
    val description: String,
    val empcode: String,
    val id: String,
    val image: String,
    val name: String
) : Parcelable