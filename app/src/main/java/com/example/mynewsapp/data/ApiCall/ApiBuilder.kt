package com.example.mynewsapp.data.ApiCall

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiBuilder {
    fun provideApi() =
        Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService::class.java)

}