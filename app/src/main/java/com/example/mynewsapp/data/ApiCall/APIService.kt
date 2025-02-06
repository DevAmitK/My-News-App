package com.example.mynewsapp.data.ApiCall

import com.example.mynewsapp.data.model.NewsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String = "us",
        @Query("category") category: String?,
        @Query("apiKey") apiKey: String = "66e20f9267fd40f78e191fc69864d51d"
    ): NewsModel

    @GET("everything")
    suspend fun getEverything(
        @Query("q") q: String ="Android",
        @Query("apiKey") apiKey: String = "66e20f9267fd40f78e191fc69864d51d"
    ): NewsModel

}