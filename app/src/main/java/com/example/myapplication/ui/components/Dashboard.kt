package com.example.myapplication.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R

class Dashboard {
    @Composable
    fun Right(show: Boolean) {
        AnimatedVisibility(
            visible = show,
            enter = slideInHorizontally(
                // Enters by sliding down from offset -fullHeight to 0.
                initialOffsetX = { fullWidth -> -fullWidth},
                animationSpec = tween(durationMillis = 2000, easing = LinearOutSlowInEasing)
            ),
            exit = slideOutVertically(
                // Exits by sliding up from offset 0 to -fullHeight.
                targetOffsetY = { fullWidth -> +fullWidth },
                animationSpec = tween(durationMillis = 250, easing = FastOutLinearInEasing)
            )
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth(0.33F)
                    .fillMaxHeight(0.27F)
                    .padding(0.dp, 0.dp, 25.dp, 0.dp) ,
                color = Color.Transparent
            ) {
                Row (
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(15.dp)
                ){
                    Image(
                        painter = painterResource(R.drawable.logo),
                        contentDescription = "logo",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(80.dp,80.dp)
                    )
                }
            }
        }
    }

    @Composable
    fun Left(show: Boolean) {
        AnimatedVisibility(
            visible = show,
            enter = slideInHorizontally(
                // Enters by sliding down from offset -fullHeight to 0.
                initialOffsetX = { fullWidth -> +fullWidth},
                animationSpec = tween(durationMillis = 2000, easing = LinearOutSlowInEasing)
            ),
            exit = slideOutVertically(
                // Exits by sliding up from offset 0 to -fullHeight.
                targetOffsetY = { fullWidth -> -fullWidth },
                animationSpec = tween(durationMillis = 250, easing = FastOutLinearInEasing)
            )
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth(0.33F)
                    .fillMaxHeight(0.27F)
                    .padding(0.dp, 0.dp, 15.dp, 0.dp) ,
                color = Color.Transparent
            ) {
                Box (
                    modifier = Modifier.padding(0.dp)
                ){
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 10.dp, 0.dp, 0.dp),
                        horizontalAlignment = Alignment.End,
                        verticalArrangement = Arrangement.Center,
                    ){
                        Box(
                            modifier = Modifier
                                .size(80.dp)
                                .clip(shape = CircleShape)
                                .background(Color.Blue)
                        )
                    }

                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 10.dp, 0.dp, 0.dp),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Center,
                    ){
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(80.dp)
                                .padding(0.dp, 0.dp, 40.dp, 0.dp)
                                .background(Color.Blue)
                        )
                    }

                    Row (
                        verticalAlignment = Alignment.Top,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(43.dp,12.dp,2.dp,0.dp)
                    ){
                        Image(
                            painter = painterResource(R.drawable.engin),
                            contentDescription = "engin",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .size(76.dp,76.dp)
                        )
                    }
                }
            }
        }
    }

    @Composable
    fun Main(show: Boolean) {
        AnimatedVisibility(
            visible = show,
            enter = slideInVertically(
                // Enters by sliding down from offset -fullHeight to 0.
                initialOffsetY = { fullHeight -> +fullHeight},
                animationSpec = tween(durationMillis = 2000, easing = LinearOutSlowInEasing)
            ),
            exit = slideOutVertically(
                // Exits by sliding up from offset 0 to -fullHeight.
                targetOffsetY = { fullHeight -> -fullHeight },
                animationSpec = tween(durationMillis = 250, easing = FastOutLinearInEasing)
            )
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                color = Color.Transparent
            ) {
                Box (
                    modifier = Modifier.padding(0.dp)
                ){
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.Top,
                        horizontalArrangement = Arrangement.Center,
                    ){
                        Box(
                            modifier = Modifier
                                .size(80.dp)
                                .clip(shape = CircleShape)
                                .background(Color.Blue)
                        )
                    }

                    Row (
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                    ){
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth()
                                .padding(0.dp, 37.5.dp, 0.dp, 0.dp)
                                .background(Color.Blue)
                        ){
                            Row (
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(0.dp, 0.dp, 0.dp, 23.dp),
                                verticalAlignment = Alignment.Bottom,
                                horizontalArrangement = Arrangement.Center,
                            ) {
                                Text(text = "-Navigator-", color = Color.White, style = Typography().labelSmall)
                            }
                        }
                    }

                    Row (
                        verticalAlignment = Alignment.Top,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(2.dp)
                    ){
                        FloatingActionButton(
                            modifier = Modifier
                                .size(75.dp)
                                .clip(shape = CircleShape),
                            content = {
                                Icon( modifier = Modifier.size(37.dp)
                                    , imageVector = Icons.Filled.LocationOn
                                    , contentDescription = "LocationOn"
                                    , tint = Color.Blue
                                ) },
                            onClick = {}
                        )
                    }
                }
            }
        }
    }
}