package com.example.myapplication.ui.components

import android.annotation.SuppressLint
import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsCarFilled
import androidx.compose.material.icons.filled.Hearing
import androidx.compose.material.icons.filled.QuestionMark
import androidx.compose.material.icons.filled.SettingsSuggest
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RadialGradientShader
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

        Menu().Draw(show = shown)
        CarOption().Options()
        Car().Draw(show = shown)

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
                Dashboard().Main(show = shown)
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
            horizontalArrangement = Arrangement.End)
        {
            Dashboard().Right(show = shown)
        }

        Row (modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Start)
        {
            Dashboard().Left(show = shown)
        }
    }

    LaunchedEffect(animatedFloat) {
        delay(500)
        shown= !shown
    }
}

