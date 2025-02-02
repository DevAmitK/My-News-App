package com.example.mynewsapp.ui_Layer.Search

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItemDefaults.containerColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.mynewsapp.ui_Layer.Home_Screen.NewsList
import com.example.mynewsapp.ui_Layer.ViewModel.ViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun sc(navController: NavController, viewModel: ViewModel) {
    Scaffold (
        containerColor = MaterialTheme.colorScheme.primary,
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.tertiary
                ),
                title = {
                Text(text = "News App")
            },
                navigationIcon = {
                    IconButton(onClick = {
                        viewModel.searchData.value = null
                        navController.navigateUp()
                    }) {
                        Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription ="" )

                    }
                })
        }
    ) {
        var searchQuery by remember { mutableStateOf("") }

        Column(Modifier.padding(it).fillMaxSize().background(MaterialTheme.colorScheme.primary)) {
            SearchBox(query = searchQuery, onQueryChange = { searchQuery = it }) {
                viewModel.getTopNews(category = null, q = searchQuery)
            }

            NewsList(data = viewModel.searchData.value, navController = navController)

        }
    }
}