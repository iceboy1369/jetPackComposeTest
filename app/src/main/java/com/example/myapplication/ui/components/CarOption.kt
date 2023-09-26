package com.example.myapplication.ui.components

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BatteryChargingFull
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.SignalCellularAlt
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.white
import kotlinx.coroutines.delay

class CarOption {
    @Preview(showSystemUi = true, backgroundColor = 0xFFAF2020, showBackground = true)
    @Composable

    fun Options() {
        var opt1 by remember { mutableStateOf(false) }
        var opt2 by remember { mutableStateOf(false) }
        var opt3 by remember { mutableStateOf(false) }
        var opt4 by remember { mutableStateOf(false) }
        var opt5 by remember { mutableStateOf(false) }
        var opt6 by remember { mutableStateOf(false) }
        var opt7 by remember { mutableStateOf(false) }
        var opt8 by remember { mutableStateOf(false) }
        var opt9 by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxHeight(0.60F)
                .fillMaxWidth()
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Blue)
                    .weight(0.195F),
                contentAlignment = Alignment.Center
            ) {
                Spacer(modifier = Modifier
                    .drawWithCache {
                        val path = Path()
                        path.moveTo(0f, size.height / 2f)
                        path.lineTo(size.width, size.height / 2f)
                        path.close()
                        onDrawBehind {
                            drawPath(path, Color.White, style = Stroke(width = 3f))
                        }
                    }
                    .fillMaxSize()
                )

                Text(
                    "SYSTEM ONLINE",
                    modifier = Modifier
                        .drawBehind {
                            drawRoundRect(
                                Color.White,
                                cornerRadius = CornerRadius(10.dp.toPx())
                            )
                        }
                        .padding(15.dp, 0.dp, 15.dp, 0.dp),
                    color = Color.Blue,
                    style = Typography().titleLarge
                )

                Row(modifier = Modifier
                    .fillMaxSize(),
                    Arrangement.Center,
                    Alignment.Bottom) {

                    AnimatedVisibility(
                        visible = opt3,
                        enter = fadeIn(
                            animationSpec = tween(durationMillis = 500, easing = LinearOutSlowInEasing)
                        ),
                        exit = fadeOut(
                            animationSpec = tween(durationMillis = 250, easing = FastOutLinearInEasing)
                        )
                    ) {
                        Text(
                            text = "شارژ سیم کارت ردیاب : 105980 ریال",
                            color = Color.White,
                            style = Typography().titleSmall
                        )
                    }
                }
            }

            Row (modifier = Modifier
                .weight(0.145F, fill = true)
                .fillMaxHeight()) {

                Row(modifier = Modifier
                    .weight(0.35F, fill = true)
                    .padding(10.dp, 15.dp, 10.dp, 0.dp)
                    .fillMaxHeight()) {

                    AnimatedVisibility(
                        visible = opt4,
                        enter = fadeIn(
                            animationSpec = tween(durationMillis = 500, easing = LinearOutSlowInEasing)
                        ),
                        exit = fadeOut(
                            animationSpec = tween(durationMillis = 250, easing = FastOutLinearInEasing)
                        )
                    ) {
                        Box (modifier = Modifier.fillMaxSize()) {
                            Canvas(modifier = Modifier.fillMaxSize()) {
                                val canvasWidth = size.width
                                val canvasHeight = size.height
                                drawLine(
                                    start = Offset(
                                        x = canvasWidth / 8f,
                                        y = canvasHeight / 1.8f
                                    ),
                                    end = Offset(
                                        x = canvasWidth / 1.3f,
                                        y = canvasHeight / 1.8f
                                    ),
                                    color = Color.White,
                                    strokeWidth = 6f
                                )
                                drawLine(
                                    start = Offset(x = canvasWidth / 1.31f, y = canvasHeight / 1.8f),
                                    end = Offset(x = canvasWidth / 1.183f, y = canvasHeight / 1.01f),
                                    color = Color.White,
                                    strokeWidth = 6f
                                )

                            }
                        }
                        Column (modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center) {
                            Text(modifier = Modifier.padding(0.dp, 0.dp, 10.dp, 18.dp),
                                text = "قفل کودک: غیرفعال",
                                color= Color.White,
                                style = Typography().labelSmall)
                        }
                    }

                }

                Row(modifier = Modifier
                    .weight(0.3F, fill = true)
                    .fillMaxHeight()) {

                    AnimatedVisibility(
                        visible = opt7,
                        enter = fadeIn(
                            animationSpec = tween(durationMillis = 500, easing = LinearOutSlowInEasing)
                        ),
                        exit = fadeOut(
                            animationSpec = tween(durationMillis = 250, easing = FastOutLinearInEasing)
                        )
                    ) {
                        Row (modifier = Modifier.fillMaxSize(),
                            verticalAlignment = Alignment.Bottom,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(text = "11.7 V", color= Color.White, modifier = Modifier.padding(0.dp,0.dp,0.dp,6.dp))
                            Icon(
                                Icons.Default.BatteryChargingFull,
                                contentDescription = "car",
                                tint = Color.White,
                                modifier = Modifier.size(30.dp)
                            )
                        }
                    }
                }

                Row(modifier = Modifier
                    .weight(0.35F, fill = true)
                    .padding(10.dp, 15.dp, 10.dp, 0.dp)
                    .fillMaxHeight()) {

                    AnimatedVisibility(
                        visible = opt2,
                        enter = fadeIn(
                            animationSpec = tween(durationMillis = 500, easing = LinearOutSlowInEasing)
                        ),
                        exit = fadeOut(
                            animationSpec = tween(durationMillis = 250, easing = FastOutLinearInEasing)
                        )
                    ) {
                        Box (modifier = Modifier
                            .fillMaxSize().padding(0.dp)) {
                            Canvas(modifier = Modifier.fillMaxSize()) {
                                val canvasWidth = size.width
                                val canvasHeight = size.height
                                drawLine(
                                    start = Offset(
                                        x = canvasWidth / 4.7f,
                                        y = canvasHeight / 1.8f
                                    ),
                                    end = Offset(
                                        x = canvasWidth / 1.15f,
                                        y = canvasHeight / 1.8f
                                    ),
                                    color = Color.White,
                                    strokeWidth = 6f
                                )
                                drawLine(
                                    start = Offset(x = canvasWidth / 4.6f, y = canvasHeight / 1.8f ),
                                    end = Offset(x = canvasWidth / 7f, y = canvasHeight / 0.99f ),
                                    color = Color.White,
                                    strokeWidth = 6f
                                )

                            }
                        }
                        Column (modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center) {
                            Text(modifier = Modifier.padding(3.dp, 0.dp, 0.dp, 18.dp),
                                text = "قفل خودکار: غیرفعال",
                                color= Color.White,
                                style = Typography().labelSmall)
                        }
                    }
                }
            }

            Row (modifier = Modifier
                .weight(0.15F, fill = true)
                .fillMaxHeight()) {

                Row(modifier = Modifier
                    .weight(0.33F, fill = true)
                    .padding(10.dp, 0.dp, 10.dp, 0.dp)
                    .fillMaxHeight()) {

                    AnimatedVisibility(
                        visible = opt5,
                        enter = fadeIn(
                            animationSpec = tween(durationMillis = 500, easing = LinearOutSlowInEasing)
                        ),
                        exit = fadeOut(
                            animationSpec = tween(durationMillis = 250, easing = FastOutLinearInEasing)
                        )
                    ) {
                        Box (modifier = Modifier
                            .fillMaxSize().padding(0.dp,0.dp,0.dp,5.dp)) {
                            Canvas(modifier = Modifier.fillMaxSize()) {
                                val canvasWidth = size.width
                                val canvasHeight = size.height
                                drawLine(
                                    start = Offset(
                                        x = canvasWidth / 8f,
                                        y = canvasHeight / 1.8f
                                    ),
                                    end = Offset(
                                        x = canvasWidth / 1.5f,
                                        y = canvasHeight / 1.8f
                                    ),
                                    color = Color.White,
                                    strokeWidth = 6f
                                )
                                drawLine(
                                    start = Offset(x = canvasWidth / 1.5f, y = canvasHeight / 1.85f),
                                    end = Offset(x = canvasWidth / 1.3f, y = canvasHeight / 2f + 40),
                                    color = Color.White,
                                    strokeWidth = 6f
                                )
                            }
                        }

                        Column (modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center) {
                            Text(modifier = Modifier.padding(0.dp, 0.dp, 18.dp, 20.dp),
                                text = "آژیرضربه:فعال",
                                color= Color.White,
                                style = Typography().labelSmall)
                        }
                    }
                }

                Spacer (modifier = Modifier
                    .weight(0.5F, fill = true)
                    .fillMaxHeight())

                Row(modifier = Modifier
                    .weight(0.33F, fill = true)
                    .padding(10.dp, 0.dp, 10.dp, 0.dp)
                    .fillMaxHeight()) {

                    AnimatedVisibility(
                        visible = opt1,
                        enter = fadeIn(
                            animationSpec = tween(durationMillis = 500, easing = LinearOutSlowInEasing)
                        ),
                        exit = fadeOut(
                            animationSpec = tween(durationMillis = 250, easing = FastOutLinearInEasing)
                        )
                    ) {
                        Box (modifier = Modifier
                            .fillMaxSize().padding(0.dp,0.dp,0.dp,5.dp)) {
                            Canvas(modifier = Modifier.fillMaxSize()) {
                                val canvasWidth = size.width
                                val canvasHeight = size.height
                                drawLine(
                                    start = Offset(
                                        x = canvasWidth / 3f,
                                        y = canvasHeight / 2f
                                    ),
                                    end = Offset(
                                        x = canvasWidth / 1.1f,
                                        y = canvasHeight / 2f
                                    ),
                                    color = Color.White,
                                    strokeWidth = 6f
                                )
                                drawLine(
                                    start = Offset(x = canvasWidth / 3f +1, y = canvasHeight / 2f),
                                    end = Offset(x = canvasWidth / 4f, y = canvasHeight / 2f + 40),
                                    color = Color.White,
                                    strokeWidth = 6f
                                )
                            }
                        }
                        Column (modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center) {
                            Text(modifier = Modifier.padding(20.dp, 0.dp, 0.dp, 25.dp),
                                text = "سرعت: 0",
                                color= Color.White,
                                style = Typography().labelSmall)
                        }
                    }
                }
            }

            Row (modifier = Modifier
                .weight(0.18F, fill = true)
                .fillMaxWidth()) {

                Row(modifier = Modifier
                    .weight(0.28F, fill = true)
                    .fillMaxHeight()) {

                    AnimatedVisibility(
                        visible = opt8,
                        enter = fadeIn(
                            animationSpec = tween(durationMillis = 500, easing = LinearOutSlowInEasing)
                        ),
                        exit = fadeOut(
                            animationSpec = tween(durationMillis = 250, easing = FastOutLinearInEasing)
                        )
                    ) {
                        Row (modifier = Modifier.fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(text = "GPS\nSIGNAL", color= Color.White, style = Typography().labelSmall)
                            Spacer (modifier = Modifier
                                .width(10.dp)
                                .fillMaxHeight())
                            Icon(
                                Icons.Default.SignalCellularAlt,
                                contentDescription = "car",
                                tint = Color.White,
                                modifier = Modifier.size(15.dp)
                            )
                        }
                    }
                }

                Spacer (modifier = Modifier
                    .weight(0.44F, fill = true)
                    .fillMaxHeight())

                Row(modifier = Modifier
                    .weight(0.28F, fill = true)
                    .fillMaxHeight()) {

                    AnimatedVisibility(
                        visible = opt6,
                        enter = fadeIn(
                            animationSpec = tween(durationMillis = 500, easing = LinearOutSlowInEasing)
                        ),
                        exit = fadeOut(
                            animationSpec = tween(durationMillis = 250, easing = FastOutLinearInEasing)
                        )
                    ) {
                        Row (modifier = Modifier.fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                Icons.Default.SignalCellularAlt,
                                contentDescription = "car",
                                tint = Color.White,
                                modifier = Modifier.size(15.dp)
                            )
                            Spacer (modifier = Modifier
                                .width(10.dp)
                                .fillMaxHeight())
                            Text(text = "GSM \n SIGNAL", color= Color.White, style = Typography().labelSmall)
                        }
                    }
                }

            }

            Row (modifier = Modifier
                .weight(0.19F, fill = true)
                .fillMaxWidth()) {

                Row(modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.15F, fill = true)
                ) {

                    AnimatedVisibility(
                        visible = opt8,
                        enter = fadeIn(
                            animationSpec = tween(durationMillis = 500, easing = LinearOutSlowInEasing)
                        ),
                        exit = fadeOut(
                            animationSpec = tween(durationMillis = 250, easing = FastOutLinearInEasing)
                        )
                    ) {
                        Row (modifier = Modifier.fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.End
                        ) {
                            Icon(
                                Icons.Default.DirectionsCar,
                                contentDescription = "car",
                                tint = Color.White,
                                modifier = Modifier.size(30.dp)
                            )
                        }
                    }
                }

                Spacer (modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.7F, fill = true))

                Row(modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.15F, fill = true)
                ) {

                    AnimatedVisibility(
                        visible = opt6,
                        enter = fadeIn(
                            animationSpec = tween(durationMillis = 500, easing = LinearOutSlowInEasing)
                        ),
                        exit = fadeOut(
                            animationSpec = tween(durationMillis = 250, easing = FastOutLinearInEasing)
                        )
                    ) {
                        Row (modifier = Modifier.fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Icon(
                                Icons.Default.Lock,
                                contentDescription = "car",
                                tint = Color.White,
                                modifier = Modifier.size(30.dp)
                            )
                        }
                    }
                }
            }

            Row(modifier = Modifier
                .fillMaxHeight()
                .weight(0.3F, fill = true)
            ) {

                AnimatedVisibility(
                    visible = opt9,
                    enter = fadeIn(
                        animationSpec = tween(durationMillis = 500, easing = LinearOutSlowInEasing)
                    ),
                    exit = fadeOut(
                        animationSpec = tween(durationMillis = 250, easing = FastOutLinearInEasing)
                    )
                ) {
                    Box (modifier = Modifier
                        .fillMaxSize().padding(0.dp,0.dp,0.dp,15.dp)){
                        Canvas(modifier = Modifier.fillMaxSize()) {
                            val canvasWidth = size.width
                            val canvasHeight = size.height
                            drawLine(
                                start = Offset(x = canvasWidth/4f, y = canvasHeight/2f),
                                end = Offset(x = canvasWidth/4f, y = canvasHeight/2f +50),
                                color = Color.White,
                                strokeWidth = 6f
                            )
                            drawLine(
                                start = Offset(x = canvasWidth/4f, y = canvasHeight/2f +50),
                                end = Offset(x = canvasWidth/1.3f, y = canvasHeight/2f +50),
                                color = Color.White,
                                strokeWidth = 6f
                            )
                            drawLine(
                                end = Offset(x = canvasWidth/1.3f, y = canvasHeight/2f +50),
                                start = Offset(x = canvasWidth/1.3f, y = canvasHeight/2f),
                                color = Color.White,
                                strokeWidth = 6f
                            )
                            drawLine(
                                end = Offset(x = canvasWidth/2, y = canvasHeight/2 +50),
                                start = Offset(x = canvasWidth/2 , y = canvasHeight/2 + 95),
                                color = Color.White,
                                strokeWidth = 6f
                            )
                        }
                        Row (modifier = Modifier
                            .fillMaxSize().padding(0.dp,5.dp,0.dp,0.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(text = "خودرو خاموش است",
                                color = white,
                                style = Typography().titleSmall,
                                modifier = Modifier.padding(0.dp,0.dp,0.dp,13.dp))
                        }
                    }
                    Row (modifier = Modifier
                        .fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.Bottom
                    ){
                        Text(text = "تاریخ وضعیت : 1402/07/04 08:24:34",
                            color = white,
                            style = Typography().titleSmall,
                            modifier = Modifier.padding(0.dp,0.dp,0.dp,10.dp)
                        )
                    }

                }
            }
        }


        val mContext = LocalContext.current
        val animatedFloat = remember { Animatable(0f) }
        LaunchedEffect(animatedFloat) {
            delay(2000)
            playMusic(mContext)
            opt1= !opt1
            delay(500)
            playMusic(mContext)
            opt2= !opt2
            delay(500)
            playMusic(mContext)
            opt3= !opt3
            delay(500)
            playMusic(mContext)
            opt4= !opt4
            delay(500)
            playMusic(mContext)
            opt5= !opt5
            delay(500)
            playMusic(mContext)
            opt6= !opt6
            delay(500)
            playMusic(mContext)
            opt7= !opt7
            delay(500)
            playMusic(mContext)
            opt8= !opt8
            delay(500)
            playMusic(mContext)
            opt9= !opt9
        }
    }

    private fun playMusic(context: Context){
        val mMediaPlayer = MediaPlayer.create(context, R.raw.check)
        mMediaPlayer.start()
    }
}