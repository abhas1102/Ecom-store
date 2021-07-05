package com.example.fakestore.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class FakestoreProducts(
    val id: String,
    val image: String,
    val title: String,
    val description: String,
    val price: Double

):Parcelable

