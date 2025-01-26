package com.example.mynewsapp.data.model

data class NewsModel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int,
)