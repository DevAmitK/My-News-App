package com.example.mynewsapp.ui_Layer.Home_Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.SubcomposeAsyncImage
import com.example.mynewsapp.R
import com.example.mynewsapp.data.model.NewsModel
import com.example.mynewsapp.ui.theme.newsAppSecondaryColour
import com.example.mynewsapp.ui_Layer.navigation.SingleNewsRout

@Composable
fun NewsList(data: NewsModel?, navController: NavController) {
        LazyColumn {
            if (data != null) {
                items(data!!.articles) { news ->

                    Spacer(modifier = Modifier.height(5.dp))
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(2.dp)
                            .background(Color.Gray)
                    )
                    Spacer(modifier = Modifier.height(5.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                navController.navigate(
                                    SingleNewsRout(
                                        title = news.title,
                                        desp = news.content,
                                        imageUrl = news.urlToImage,
                                        dateAndTime = news.publishedAt,
                                        newsUrl = news.url
                                    )
                                )
                            }
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(0.45f)
                                .fillMaxHeight(),
                            verticalArrangement = Arrangement.Center
                        ) {
                            SubcomposeAsyncImage(
                                model = news.urlToImage ?: R.drawable.no_image,
                                contentDescription = null,
                                modifier = Modifier.fillMaxWidth(),
                            )


                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        Column(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                color = Color.Black,
                                text = news.title ?: "No Title",
                                fontFamily = FontFamily.Monospace,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                maxLines = 3
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(5.dp))

                }

            }

        }


    }
