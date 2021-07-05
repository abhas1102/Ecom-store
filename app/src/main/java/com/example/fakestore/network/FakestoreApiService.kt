package com.example.fakestore.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

import retrofit2.http.GET

private const val BASE_URL = "https://fakestoreapi.com"
private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build() // Added KotlinJsonAdapterFactory() so that Moshis annotation can work properly with Kotlin
private val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL).build()

interface FakestoreApiService{
    @GET("products")
   suspend fun getProducts() : List<FakestoreProducts>
}


object FakestoreApi{
    val retrofitService : FakestoreApiService by lazy {
        retrofit.create(FakestoreApiService::class.java)
    }
}

