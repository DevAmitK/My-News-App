package com.example.mynewsapp.ui_Layer.Home_Screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerValue.Closed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mynewsapp.ui.theme.newsAppMainColour2
import com.example.mynewsapp.ui.theme.newsAppMainColourLight
import com.example.mynewsapp.ui_Layer.ViewModel.ViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: ViewModel) {

    val drawerState = rememberDrawerState(initialValue = Closed)
    val cc = rememberCoroutineScope()
    val context = LocalContext

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            //DRAWER SCREEN
            ModalDrawerSheet {
                Column(
                    Modifier
                        .fillMaxSize()
                        .background(newsAppMainColourLight)
                ) {
                    Icon(imageVector =Icons.Default.Person, contentDescription ="")
                    Text(
                        text = "Amit KK",
                        fontSize = 20.sp,
                        fontFamily = FontFamily.Monospace,
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Bold,

                    )

                }
            }
        }) {
        // HOME SCREEN
        Scaffold(
            containerColor = MaterialTheme.colorScheme.primary,
            topBar = {
                CenterAlignedTopAppBar(
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = newsAppMainColour2
                    ),
                    title = { Text(text = "News App") },
                    navigationIcon = {
                        IconButton(onClick = {
                            cc.launch {
                                drawerState.open()
                            }

                        }) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = null)

                        }
                    },
                    actions = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Default.Search, contentDescription = null)
                        }
                    })

            }
        ) {
            Box(modifier = Modifier.padding(it)) {


                LazyColumn {
                    if (viewModel.data.value != null) {
                        items(viewModel.data.value!!.articles) { news ->
                            Text(
                                text = "${news.title}",
                                fontSize = 20.sp,
                                fontFamily = FontFamily.Monospace,
                                color = Color.DarkGray,
                                fontWeight = FontWeight.Bold
                            )
                            Text(text = "")
                        }

                    } else {
                        item {
                            Column(
                                Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                CircularProgressIndicator()

                            }
                        }
                    }

                }

            }
        }


    }

}


