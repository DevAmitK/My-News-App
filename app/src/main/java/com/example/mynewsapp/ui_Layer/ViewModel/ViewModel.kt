package com.example.mynewsapp.ui_Layer.ViewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynewsapp.data.ApiCall.ApiBuilder
import com.example.mynewsapp.data.model.NewsModel
import kotlinx.coroutines.launch

class ViewModel : ViewModel() {

    var data = mutableStateOf<NewsModel?>(null)

    fun getTopNews(category : String?){
        viewModelScope.launch {
            if (category == null){
                data.value = ApiBuilder.provideApi().getTopHeadlines()
                Log.d("DaTa", "getTopNews: null ${data.value}")
            }else{
                data.value = ApiBuilder.provideApi().getCategoryNews(category = "business")
                Log.d("DaTa", "getTopNews:category ${data.value} ")

            }
        }
    }

}