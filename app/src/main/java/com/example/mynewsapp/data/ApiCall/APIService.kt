package com.example.mynewsapp.data.ApiCall

import com.example.mynewsapp.data.model.NewsModel
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String = "a98b0bbe8caa4bcca2c845fd70aa9d58"
    ): NewsModel

    @GET("top-headlines")
    suspend fun getCategoryNews(
        @Query("country") country: String = "us",
        @Query("category") category: String,
        @Query("apiKey") apiKey: String = "a98b0bbe8caa4bcca2c845fd70aa9d58"
    ): NewsModel

}