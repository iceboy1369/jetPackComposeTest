package com.example.myapplication.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CarRental
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.LockOpen
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class Menu {
    @Preview(showSystemUi = true)
    @Composable
    fun Draw(show: Boolean = true) {

        AnimatedVisibility(
            visible = show,
            enter = slideInVertically(
                // Enters by sliding down from offset -fullHeight to 0.
                initialOffsetY = { -300 },
                animationSpec = tween(durationMillis = 1500, easing = LinearOutSlowInEasing)
            ),
            exit = slideOutVertically(
                // Exits by sliding up from offset 0 to -fullHeight.
                targetOffsetY = { fullHeight -> +fullHeight },
                animationSpec = tween(durationMillis = 250, easing = FastOutLinearInEasing)
            )
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth().padding(0.dp, 30.dp, 0.dp, 0.dp),
                color = Color.Transparent
            ) {
                Box {
                    Canvas(modifier = Modifier.fillMaxSize()) {
                        val arcRadius = 110f
                        val canvasHeight = size.height

                        val canvasQuadrantSize = canvasHeight / 2 - (arcRadius / 2) + 345
                        drawRect(
                            color = Color.Blue,
                            size = Size(canvasQuadrantSize, canvasQuadrantSize)
                        )

                        drawArc(
                            color = Color(red = 17, green = 105, blue = 175, alpha = 255),
                            startAngle = 150f, //start angle is always in clockwise direction
                            sweepAngle = -120f, // angle formed between the start angle
                            useCenter = false,
                            size = Size(1300f, 250f),
                            topLeft = Offset(
                                -100f,
                                canvasHeight / 2 - (arcRadius / 2) + 150F
                            ),
                            style = Stroke(width = 150f, cap = StrokeCap.Round)
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(0.dp, 235.dp, 0.dp, 0.dp)
                    ,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                )
                {

                    Column(
                        modifier = Modifier
                            .weight(weight = 0.2f, fill = true)
                            .fillMaxHeight(0.12F)
                            .padding(0.dp, 5.dp, 0.dp, 0.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            Icons.Default.VolumeUp,
                            contentDescription = "car",
                            tint = Color.White,
                            modifier = Modifier.size(30.dp)
                        )
                    }

                    Divider(
                        modifier = Modifier
                            .width(1.dp)
                            .fillMaxHeight(0.15F)
                            .padding(0.dp, 36.dp, 0.dp, 15.dp),
                        color = Color.White
                    )
                    Column(
                        modifier = Modifier
                            .weight(weight = 0.21f, fill = true)
                            .fillMaxHeight(0.12F)
                            .padding(0.dp, 25.dp, 0.dp, 0.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            Icons.Default.Lock,
                            contentDescription = "car",
                            tint = Color.White,
                            modifier = Modifier.size(30.dp)
                        )
                    }

                    Divider(
                        modifier = Modifier
                            .width(1.dp)
                            .fillMaxHeight(0.15F)
                            .padding(0.dp, 40.dp, 0.dp, 9.dp),
                        color = Color.White
                    )
                    Column(
                        modifier = Modifier
                            .weight(weight = 0.21f, fill = true)
                            .fillMaxHeight(0.12F)
                            .padding(0.dp, 25.dp, 0.dp, 0.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            Icons.Filled.LockOpen,
                            contentDescription = "car",
                            tint = Color.White,
                            modifier = Modifier.size(30.dp)
                        )
                    }

                    Divider(
                        modifier = Modifier
                            .width(1.dp)
                            .fillMaxHeight(0.15F)
                            .padding(0.dp, 36.dp, 0.dp, 15.dp),
                        color = Color.White
                    )

                    Column(
                        modifier = Modifier
                            .weight(weight = 0.2f, fill = true)
                            .fillMaxHeight(0.12F)
                            .padding(0.dp, 5.dp, 0.dp, 0.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            Icons.Default.CarRental,
                            contentDescription = "car",
                            tint = Color.White,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
            }
        }
    }
}