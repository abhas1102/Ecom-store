package com.example.fakestore

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fakestore.network.FakestoreApi
import com.example.fakestore.network.FakestoreProducts
import kotlinx.coroutines.launch

class ItemsListViewModel : ViewModel() {

  //  private val _status = MutableLiveData<String>() // The internal Live Data that stores the status of most recent request
   // val status:LiveData<String> = _status // External live data for request status

    private val _status = MutableLiveData<String>()
    val status:LiveData<String> = _status

    private val _product = MutableLiveData<List<FakestoreProducts>>()
    val product : LiveData<List<FakestoreProducts>> = _product

  //  private val _productPrice = MutableLiveData<Double>()
  //  val productPrice:LiveData<Double> = _productPrice

    //private val _products = MutableLiveData<List<FakestoreProducts>>() // Internal live data that stores the object received from web server
    //var products :LiveData<List<FakestoreProducts>> = _products

//    private val _products1 = MutableLiveData<FakestoreProducts>() // Internal live data that stores the object received from web server
  //  val products1 :LiveData<FakestoreProducts> = _products1

    // Internally, we use a MutableLiveData to handle navigation to the selected property
   // private val _navigateToSelectedProduct = MutableLiveData<FakestoreProducts?>()

    // The external immutable LiveData for the navigation property
   // val navigateToSelectedProduct: LiveData<FakestoreProducts?>
   //     get() = _navigateToSelectedProduct

    private val _navigateToSelectedProduct = MutableLiveData<FakestoreProducts?>()
    val navigateToSelectedProduct: MutableLiveData<FakestoreProducts?>
    get() = _navigateToSelectedProduct


    init {
        getFakestoreProducts()
    }

    private fun getFakestoreProducts(){
        viewModelScope.launch {
        //    val listResult = FakestoreApi.retrofitService.getProducts()

            _product.value = FakestoreApi.retrofitService.getProducts()

       //  _products.value = FakestoreApi.retrofitService.getProducts()
         //   _products1.value = FakestoreApi.retrofitService.getProducts()[1]
        //   _status.value = "Success: ${listResult.size} Fake products retrieved"
       //   _status.value = "First image url: ${_products.value}"

        }
    }

  /*  private fun getPrice(fakestoreProducts: FakestoreProducts){
        _productPrice.value = fakestoreProducts.price
    } */


    /**
     * After the navigation has taken place, make sure navigateToSelectedProperty is set to null
     */
    fun displayProductDetails(fakestoreProducts: FakestoreProducts){
        _navigateToSelectedProduct.value = fakestoreProducts
    }

    fun displayProductDetailsComplete(){
        _navigateToSelectedProduct.value = null
    }

}