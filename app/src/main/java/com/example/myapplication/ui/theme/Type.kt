package com.example.myapplication.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

val iranSansFamily = FontFamily(
    Font(R.font.iran_sans)
)

val typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = iranSansFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = iranSansFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),

    labelSmall = TextStyle(
        fontFamily = iranSansFamily, //FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),

    bodyMedium = TextStyle(
        fontFamily = iranSansFamily,
    ),

    bodySmall = TextStyle(
        fontFamily = iranSansFamily,
    ),

    displayLarge = TextStyle(
        fontFamily = iranSansFamily,
    ),

    displayMedium = TextStyle(
        fontFamily = iranSansFamily,
    ),

    displaySmall = TextStyle(
        fontFamily = iranSansFamily,
    ),

    headlineLarge = TextStyle(
        fontFamily = iranSansFamily,
    ),

    headlineMedium = TextStyle(
        fontFamily = iranSansFamily,
    ),

    headlineSmall = TextStyle(
        fontFamily = iranSansFamily,
    ),

    labelLarge = TextStyle(
        fontFamily = iranSansFamily,
    ),

    labelMedium = TextStyle(
        fontFamily = iranSansFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
    ),

    titleMedium = TextStyle(
        fontFamily = iranSansFamily,
    ),

    titleSmall = TextStyle(
        fontFamily = iranSansFamily,
    ),
)

