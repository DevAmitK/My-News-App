package com.example.mynewsapp.ui_Layer

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.example.mynewsapp.data.ApiCall.APIService
import com.example.mynewsapp.data.ApiCall.ApiBuilder
import com.example.mynewsapp.ui.theme.MyNewsAppTheme
import com.example.mynewsapp.ui_Layer.Home_Screen.HomeScreen
import com.example.mynewsapp.ui_Layer.ViewModel.ViewModel
import com.example.mynewsapp.ui_Layer.tab_Layout.TabLayout
import kotlinx.coroutines.DelicateCoroutinesApi


class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel by viewModels<ViewModel>()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyNewsAppTheme {
                Scaffold { innerPadding ->
                    innerPadding
                   // HomeScreen(viewModel = viewModel)
                     HomeScreen(viewModel = viewModel)

                    }
                }
            }
        }
    }


