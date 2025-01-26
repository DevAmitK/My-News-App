package com.example.mynewsapp.ui_Layer.ViewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynewsapp.data.ApiCall.ApiBuilder
import com.example.mynewsapp.data.model.NewsModel
import kotlinx.coroutines.launch

class ViewModel : ViewModel() {

    var data = mutableStateOf<NewsModel?>(null)

    init {
        viewModelScope.launch {
            data.value = ApiBuilder.provideApi().getAllNews()
        }
    }

}