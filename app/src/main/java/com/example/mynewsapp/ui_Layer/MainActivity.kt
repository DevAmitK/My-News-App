package com.example.mynewsapp.ui_Layer

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Scaffold
import com.example.mynewsapp.ui.theme.MyNewsAppTheme
import com.example.mynewsapp.ui_Layer.ViewModel.ViewModel
import com.example.mynewsapp.ui_Layer.navigation.NavHostController


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
                    // News(title = "", imageUrl = "", desp = "")

                    NavHostController(viewModel)
                   // HomeScreen(viewModel = viewModel)


                }
                }
            }
        }
    }


