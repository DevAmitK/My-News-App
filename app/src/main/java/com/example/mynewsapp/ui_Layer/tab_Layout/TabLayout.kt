package com.example.mynewsapp.ui_Layer.tab_Layout

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mynewsapp.ui_Layer.Home_Screen.NewsList
import com.example.mynewsapp.ui_Layer.ViewModel.ViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TabLayout(viewModel: ViewModel,navController: NavController) {
    val tabItemsList =
        listOf(
            TabItem(
                title = "Top Headline",
                selectedColour = Color.Black,
                unselectedColour = Color.White
            ),

            TabItem(
                title = "Sports",
                selectedColour = Color.Black,
                unselectedColour = Color.White
            ),

            TabItem(
                title = "Tech",
                selectedColour = Color.Black,
                unselectedColour = Color.White
            ),
            TabItem(
                title = "Health",
                selectedColour = Color.Black,
                unselectedColour = Color.White
            ),
            TabItem(
                title = "Science",
                selectedColour = Color.Black,
                unselectedColour = Color.White
            ),
            TabItem(
                title = "Gaming",
                selectedColour = Color.Black,
                unselectedColour = Color.White
            ),
            TabItem(
                title = "Entertainment",
                selectedColour = Color.Black,
                unselectedColour = Color.White
            ),
            TabItem(
                title = "Business",
                selectedColour = Color.Black,
                unselectedColour = Color.White
            ),

            )
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val pageState = rememberPagerState { tabItemsList.size }

    LaunchedEffect(selectedTabIndex) {
        pageState.animateScrollToPage(selectedTabIndex)

    }

    LaunchedEffect(pageState.currentPage,pageState.isScrollInProgress) {
        if (!pageState.isScrollInProgress){
            selectedTabIndex = pageState.currentPage
        }
    }


    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        ScrollableTabRow(
            modifier = Modifier.height(50.dp),
            containerColor = MaterialTheme.colorScheme.secondary,
            selectedTabIndex = selectedTabIndex,
            indicator = {},
            divider = {}
        ) {
            tabItemsList.forEachIndexed { index, tabItem ->

                Tab(selected = selectedTabIndex == index,
                    onClick = {
                        selectedTabIndex = index
                        val category = when (tabItemsList[index].title) {
                            "Tech" -> "technology"
                            "Sports" -> "sports"
                            "Business" -> "business"
                            "Entertainment" -> "entertainment"
                            "Gaming" -> "gaming"
                            "Health" -> "health"
                            "Science" -> "science"
                            else -> null
                        }
                        viewModel.data.value = null
                        viewModel.getTopNews(category,null)                    }
                ) {
                    Text(
                        text = "${tabItemsList[index].title}",
                        color = if (selectedTabIndex == index) tabItemsList[index].selectedColour
                        else tabItemsList[index].unselectedColour
                    )
                }
            }

        }

        HorizontalPager(state = pageState) { index ->

            Box(modifier = Modifier.fillMaxSize()) {

                if (viewModel.data.value == null){
                    Column(modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center){
                        CircularProgressIndicator(
                            color = Color.Blue
                        )
                    }
                }
                NewsList(data = viewModel.data.value, navController = navController)

            }

        }

    }
}