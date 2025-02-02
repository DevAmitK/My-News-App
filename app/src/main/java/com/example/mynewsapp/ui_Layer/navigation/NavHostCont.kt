package com.example.mynewsapp.ui_Layer.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.mynewsapp.ui_Layer.Home_Screen.HomeScreen
import com.example.mynewsapp.ui_Layer.News.SingleNews
import com.example.mynewsapp.ui_Layer.Search.sc
import com.example.mynewsapp.ui_Layer.ViewModel.ViewModel

@Composable
fun NavHostController(viewModel: ViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = HomeScreenRout) {
        composable<HomeScreenRout> {
            HomeScreen(viewModel = viewModel, navController = navController)
        }
        composable<SingleNewsRout> {
            val news : SingleNewsRout = it.toRoute()
            SingleNews(
                title = news.title,
                desp = news.desp,
                imageUrl = news.imageUrl,
                dateAndTime = news.dateAndTime,
                newsUrl = news.newsUrl,
                navController = navController
            )

        }

        composable<ScScreenRout> {
            sc(navController = navController,viewModel)
        }


    }


}