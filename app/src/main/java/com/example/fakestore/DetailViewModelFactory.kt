package com.example.fakestore

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fakestore.network.FakestoreProducts



class DetailViewModelFactory (

    private val fakestoreProducts: FakestoreProducts,
    private val application: Application) : ViewModelProvider.Factory {
        @Suppress("unchecked_cast")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
                return DetailViewModel(fakestoreProducts, application) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
}