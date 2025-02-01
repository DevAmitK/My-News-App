package com.example.mynewsapp.data.model

import kotlinx.serialization.Serializable


data class NewsModel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int,
)