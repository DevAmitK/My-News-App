package com.example.mynewsapp.ui_Layer

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Scaffold
import com.example.mynewsapp.ui.theme.MyNewsAppTheme
import com.example.mynewsapp.ui_Layer.Home_Screen.HomeScreen
import com.example.mynewsapp.ui_Layer.ViewModel.ViewModel
import kotlinx.coroutines.DelicateCoroutinesApi

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel by viewModels<ViewModel>()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyNewsAppTheme {
                Scaffold() { innerPadding ->
                    innerPadding
                    HomeScreen(viewModel = viewModel)
                    }
                }
            }
        }
    }


