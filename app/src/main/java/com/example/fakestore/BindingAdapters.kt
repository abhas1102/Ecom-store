package com.example.fakestore

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.fakestore.network.FakestoreProducts

@BindingAdapter("imageUrl")
fun bindImage(imgView:ImageView, imgUrl:String?){
    imgUrl?.let {
        val imgUri = it.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri){
        }
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data:List<FakestoreProducts>?){
    val adapter = recyclerView.adapter as ProductGridAdapter
    adapter.submitList(data)
}





