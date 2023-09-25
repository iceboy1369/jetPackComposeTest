package com.example.myapplication.ui.components

import android.annotation.SuppressLint
import android.content.Context
import android.media.MediaPlayer
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BatteryChargingFull
import androidx.compose.material.icons.filled.CarRental
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.DirectionsCarFilled
import androidx.compose.material.icons.filled.Hearing
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.LockOpen
import androidx.compose.material.icons.filled.QuestionMark
import androidx.compose.material.icons.filled.SettingsSuggest
import androidx.compose.material.icons.filled.SignalCellularAlt
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.RadialGradientShader
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import kotlinx.coroutines.delay

@SuppressLint("CoroutineCreationDuringComposition")
@Preview(showSystemUi = true)
@Composable
fun AnimationPage() {
    val largeRadialGradient = object : ShaderBrush() {
        override fun createShader(size: Size): Shader {
            val biggerDimension = maxOf(size.height, size.width)
            return RadialGradientShader(
                colors = listOf(Color(0xFF52918E), Color(0xFF243484)),
                center = size.center,
                radius = biggerDimension / 2f,
                colorStops = listOf(0f, 3f)
            )
        }
    }
    var shown by remember { mutableStateOf(false) }
    val animatedFloat = remember { Animatable(0f) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(largeRadialGradient)
    ){

        SecondMenu(show = shown)

        FuelOptions()

        Car(show = shown)

        Row (modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceEvenly
        )
        {

            Column(modifier = Modifier
                .weight(weight = 0.2f, fill = true)
                .fillMaxHeight(0.09F)
                .background(Color.Blue),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon( Icons.Default.DirectionsCarFilled,
                    contentDescription = "car",
                    tint = Color.White,
                    modifier = Modifier.size(30.dp))
            }

            Divider(modifier = Modifier
                .width(1.dp)
                .fillMaxHeight(0.09F)
                .padding(0.dp, 8.dp, 0.dp, 8.dp),
                color = Color.White
            )

            Column(modifier = Modifier
                .weight(weight = 0.2f, fill = true)
                .fillMaxHeight(0.09F)
                .background(Color.Blue),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon( Icons.Default.Hearing,
                    contentDescription = "hear",
                    tint = Color.White,
                    modifier = Modifier.size(30.dp))
            }

            Divider(modifier = Modifier
                .width(0.9.dp)
                .fillMaxHeight(0.09F),
                color = Color.Black
            )

            Column(modifier = Modifier
                .weight(weight = 0.2f, fill = true)
                .fillMaxHeight(0.2F)
            ) {
                Dashboard(shown)
            }

            Divider(modifier = Modifier
                .width(0.9.dp)
                .fillMaxHeight(0.09F),
                color = Color.Black
            )

            Column(modifier = Modifier
                .weight(weight = 0.2f, fill = true)
                .fillMaxHeight(0.09F)
                .background(Color.Blue),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon( Icons.Default.SettingsSuggest,
                    contentDescription = "setting",
                    tint = Color.White,
                    modifier = Modifier.size(30.dp))
            }

            Divider(modifier = Modifier
                .width(1.dp)
                .fillMaxHeight(0.09F)
                .padding(0.dp, 8.dp, 0.dp, 8.dp),
                color = Color.White
            )

            Column(modifier = Modifier
                .weight(weight = 0.2f, fill = true)
                .fillMaxHeight(0.09F)
                .background(Color.Blue),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon( Icons.Default.QuestionMark,
                    contentDescription = "question",
                    tint = Color.White,
                    modifier = Modifier.size(30.dp))
            }
            
        }

        Row (modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.End
        )
        {
            RightDashboard(shown)

        }

        Row (modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Start
        )
        {
            LeftDashboard(shown)
        }
    }

    LaunchedEffect(animatedFloat) {
        delay(500)
        shown= !shown
    }
}

@Composable
fun Dashboard(show: Boolean) {
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

@Composable
fun LeftDashboard(show: Boolean) {
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
fun RightDashboard(show: Boolean) {
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
fun Car(show: Boolean) {
    AnimatedVisibility(
        visible = show,
        enter = slideInVertically(
            // Enters by sliding down from offset -fullHeight to 0.
            initialOffsetY = { -200},
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
                .fillMaxWidth()
                .fillMaxHeight(),
            color = Color.Transparent
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 0.dp, 0.dp, 170.dp),

                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ){
                Image(
                    painter =  painterResource(id = R.drawable.car),
                    contentDescription = "",
                    modifier = Modifier.size(360.dp)
                )
            }
        }
    }
}


@Composable
fun SecondMenu(show: Boolean) {
    AnimatedVisibility(
        visible = show,
        enter = slideInVertically(
            // Enters by sliding down from offset -fullHeight to 0.
            initialOffsetY = { -300},
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
                .fillMaxWidth(),
            color = Color.Transparent
        ) {
            Box {
                Canvas(modifier = Modifier.fillMaxSize()) {
                    val arcRadius = 110f
                    val canvasHeight = size.height

                    val canvasQuadrantSize = canvasHeight / 2 - (arcRadius / 2)+345
                    drawRect(color = Color.Blue, size = Size(canvasQuadrantSize,canvasQuadrantSize))

                    drawArc(
                        color = Color(red = 17, green = 105, blue = 175, alpha = 255),
                        startAngle = 150f, //start angle is always in clockwise direction
                        sweepAngle = -120f, // angle formed between the start angle
                        useCenter = false,
                        size = Size(1300f, 250f),
                        topLeft = Offset(
                            -100f,
                            canvasHeight / 2 - (arcRadius / 2)+ 150F
                        ),
                        style = Stroke(width = 150f, cap = StrokeCap.Round)
                    )
                }
            }

            Row (modifier = Modifier
                .fillMaxSize()
                .padding(0.dp, 230.dp, 0.dp, 0.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
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
                        Icons.Default.CarRental,
                        contentDescription = "car",
                        tint = Color.White,
                        modifier = Modifier.size(30.dp)
                    )
                }

                Divider(
                    modifier = Modifier
                        .width(1.dp)
                        .fillMaxHeight(0.15F)
                        .padding(0.dp, 40.dp, 0.dp, 15.dp),
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
                        .padding(0.dp, 47.dp, 0.dp, 7.dp),
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
                        .padding(0.dp, 40.dp, 0.dp, 15.dp),
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
                        Icons.Default.VolumeUp,
                        contentDescription = "car",
                        tint = Color.White,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }

        }
    }
}


@Composable
fun FuelOptions() {
    var opt1 by remember { mutableStateOf(false) }
    var opt2 by remember { mutableStateOf(false) }
    var opt3 by remember { mutableStateOf(false) }
    var opt4 by remember { mutableStateOf(false) }
    var opt5 by remember { mutableStateOf(false) }
    var opt6 by remember { mutableStateOf(false) }
    var opt7 by remember { mutableStateOf(false) }
    var opt8 by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxHeight(0.50F)
            .fillMaxWidth()
            .padding(0.dp, 0.dp, 0.dp, 0.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Blue)
                .weight(0.15F),
            contentAlignment = Alignment.Center
        ) {
            Spacer(modifier = Modifier
                .drawWithCache {
                    val path = Path()
                    path.moveTo(0f, size.height / 2f)
                    path.lineTo(size.width, size.height / 2f)
                    path.close()
                    onDrawBehind {
                        drawPath(path, Color.White, style = Stroke(width = 2f))
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
                    .padding(15.dp,0.dp,15.dp,0.dp),
                color = Color.Blue,
                style = Typography().titleLarge
            )
//            Text(
//                text = "شارژ سیم کارت ردیاب : 105980 ریال",
//                color = Color.White,
//                style = Typography().titleSmall
//            )
        }

        Row(modifier = Modifier
            .weight(0.1F, fill = true)
            .fillMaxWidth()) {

            AnimatedVisibility(
                visible = opt3,
                enter = fadeIn(
                    animationSpec = tween(durationMillis = 500, easing = LinearOutSlowInEasing)
                ),
                exit = fadeOut(
                    animationSpec = tween(durationMillis = 250, easing = FastOutLinearInEasing)
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Blue),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
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
            .weight(0.16F, fill = true)
            .fillMaxHeight()) {

            Row(modifier = Modifier
                .weight(0.33F, fill = true)
                .padding(10.dp, 30.dp, 10.dp, 0.dp)
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
                    Column (modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center) {
                        Text(modifier = Modifier.padding(0.dp, 0.dp, 20.dp, 0.dp), text = "قفل خودکار: غیرفعال", color= Color.White, style = Typography().labelSmall)

                        Row (modifier = Modifier
                            .fillMaxSize(),
                            verticalAlignment = Alignment.Top,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Divider(
                                Modifier
                                    .fillMaxWidth(0.8F)
                                    .height(2.dp))
//                    Divider(Modifier.fillMaxWidth(0.2F).height(25.dp).rotate(45F))
                        }
                    }
                }
            }

            Row(modifier = Modifier
                .weight(0.33F, fill = true)
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
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(text = "11.7 V", color= Color.White)
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
                .weight(0.33F, fill = true)
                .padding(10.dp, 30.dp, 10.dp, 0.dp)
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
                    Column (modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center) {
                        Text(modifier = Modifier.padding(20.dp, 0.dp, 0.dp, 0.dp), text = "قفل کودک: غیرفعال", color= Color.White, style = Typography().labelSmall)

                        Row (modifier = Modifier
                            .fillMaxSize(),
                            verticalAlignment = Alignment.Top,
                            horizontalArrangement = Arrangement.End
                        ) {
//                    Divider(Modifier.fillMaxWidth(0.2F).height(13.dp).padding(0.dp, 9.dp, 0.dp, 0.dp).rotate(-45F))
                            Divider(
                                Modifier
                                    .fillMaxWidth(0.8F)
                                    .height(2.dp))
                        }
                    }
                }

            }
        }

        Row (modifier = Modifier
            .weight(0.18F, fill = true)
            .fillMaxHeight()) {

            Row(modifier = Modifier
                .weight(0.33F, fill = true)
                .padding(10.dp, 30.dp, 10.dp, 0.dp)
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
                    Column (modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center) {
                        Text(modifier = Modifier.padding(0.dp, 0.dp, 20.dp, 0.dp), text = "سرعت: 0", color= Color.White, style = Typography().labelSmall)

                        Row (modifier = Modifier
                            .fillMaxSize(),
                            verticalAlignment = Alignment.Top,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Divider(
                                Modifier
                                    .fillMaxWidth(0.8F)
                                    .height(2.dp))
//                    Divider(Modifier.fillMaxWidth(0.2F).height(20.dp).rotate(-45F))
                        }
                    }
                }
            }
            Spacer (modifier = Modifier
                .weight(0.5F, fill = true)
                .fillMaxHeight())

            Row(modifier = Modifier
                .weight(0.33F, fill = true)
                .padding(10.dp, 30.dp, 10.dp, 0.dp)
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
                    Column (modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center) {
                        Text(modifier = Modifier.padding(20.dp, 0.dp, 0.dp, 0.dp), text = "آژیرضربه:فعال", color= Color.White, style = Typography().labelSmall)

                        Row (modifier = Modifier
                            .fillMaxSize(),
                            verticalAlignment = Alignment.Top,
                            horizontalArrangement = Arrangement.End
                        ) {
//                    Divider(Modifier.fillMaxWidth(0.2F).height(13.dp).padding(0.dp, 9.dp, 0.dp, 0.dp).rotate(-45F))
                            Divider(
                                Modifier
                                    .fillMaxWidth(0.8F)
                                    .height(2.dp))
                        }
                    }
                }
            }
        }

        Row (modifier = Modifier
            .weight(0.15F, fill = true)
            .fillMaxWidth()) {

            Row(modifier = Modifier
                .weight(0.2F, fill = true)
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
                        Text(text = "GSM \n SIGNAL", color= Color.White, style = Typography().labelSmall)
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
                .weight(0.6F, fill = true)
                .fillMaxHeight())

            Row(modifier = Modifier
                .weight(0.2F, fill = true)
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
                        Icon(
                            Icons.Default.SignalCellularAlt,
                            contentDescription = "car",
                            tint = Color.White,
                            modifier = Modifier.size(15.dp)
                        )
                        Spacer (modifier = Modifier
                            .width(10.dp)
                            .fillMaxHeight())
                        Text(text = "GPS\nSIGNAL", color= Color.White, style = Typography().labelSmall)
                    }
                }
            }
        }

        Row (modifier = Modifier
            .weight(0.15F, fill = true)
            .fillMaxWidth()) {

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
                        horizontalArrangement = Arrangement.End
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

            Spacer (modifier = Modifier
                .fillMaxHeight()
                .weight(0.7F, fill = true))

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
                        horizontalArrangement = Arrangement.Start
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
    }
}

fun playMusic(context: Context){
    val mMediaPlayer = MediaPlayer.create(context, R.raw.check)
    mMediaPlayer.start()
}