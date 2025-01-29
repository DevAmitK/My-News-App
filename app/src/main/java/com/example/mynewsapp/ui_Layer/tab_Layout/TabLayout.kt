package com.example.mynewsapp.ui_Layer.tab_Layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
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
import com.example.mynewsapp.ui_Layer.ViewModel.ViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TabLayout(viewModel: ViewModel) {
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
        TabRow(
            containerColor = MaterialTheme.colorScheme.secondary,
            selectedTabIndex = selectedTabIndex
        ) {
            tabItemsList.forEachIndexed { index, tabItem ->

                Tab(selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index }
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

            }

        }

    }
}