package com.example.mynewsapp.ui_Layer.Home_Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mynewsapp.ui_Layer.ViewModel.ViewModel
import com.example.mynewsapp.ui_Layer.navigation.ScScreenRout
import com.example.mynewsapp.ui_Layer.tab_Layout.TabLayout
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: ViewModel,navController: NavController) {

    val drawerState = rememberDrawerState(initialValue = Closed)
    val cc = rememberCoroutineScope()
    val context = LocalContext

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            //DRAWER SCREEN
            ModalDrawerSheet { DrawerUi() }
        }) {
        Scaffold(
            containerColor = MaterialTheme.colorScheme.primary,
            topBar = {
                CenterAlignedTopAppBar(
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.tertiary
                    ),
                    title = { Text(text = "News App", color = Color.Black) },
                    navigationIcon = {
                        IconButton(onClick = {
                            cc.launch {
                                drawerState.open()
                            }

                        }) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = null,
                                tint = Color.Black,
                                modifier = Modifier.size(35.dp))

                        }
                    },
                    actions = {
                        IconButton(onClick = {
                            navController.navigate(ScScreenRout)
                        }) {
                            Icon(imageVector = Icons.Default.Search, contentDescription = null,
                                tint = Color.Black,
                                modifier = Modifier.size(35.dp))
                        }
                    })

            }
        ) {
            Box(modifier = Modifier.padding(it)) {
               // NewTabLayout(viewModel)
                TabLayout(viewModel,navController)
            }
        }


    }

}


