package com.example.fakestore

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.fakestore.network.FakestoreProducts

class DetailViewModel(fakestoreProducts: FakestoreProducts, app:Application):AndroidViewModel(app) {

    private val _selectedProduct = MutableLiveData<FakestoreProducts>()
    val selectedProduct:LiveData<FakestoreProducts>
    get() = _selectedProduct

    init {
        _selectedProduct.value = fakestoreProducts
    }
}