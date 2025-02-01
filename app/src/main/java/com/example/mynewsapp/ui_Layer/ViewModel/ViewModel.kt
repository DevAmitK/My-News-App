package com.example.mynewsapp.ui_Layer.ViewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynewsapp.data.ApiCall.ApiBuilder
import com.example.mynewsapp.data.model.NewsModel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

class ViewModel : ViewModel() {

    var data = mutableStateOf<NewsModel?>(null)

    fun getTopNews(category : String?){
        viewModelScope.launch {
                data.value = ApiBuilder.provideApi().getTopHeadlines()
        }
    }

    fun formatDate(isoDate: String): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        inputFormat.timeZone = TimeZone.getTimeZone("UTC") // Handle Z (UTC) timezone
        val outputFormat = SimpleDateFormat("dd-MM-yy", Locale.getDefault())
        val date = inputFormat.parse(isoDate)
        return date?.let { outputFormat.format(it) } ?: "Invalid Date"
    }

}