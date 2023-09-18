package com.example.myapplication.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.example.myapplication.data.SettingViewModel

val settingViewModel = SettingViewModel()

private val darkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

val lightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40,
//    onPrimary=Color(0xFFFF0053),
//    primaryContainer=Color(0xFFFF0053),
//    onPrimaryContainer=Color(0xFFFF0053),
//    inversePrimary=Color(0xFFFF0053),
//    onSecondary=Color(0xFFFF0053),
//    secondaryContainer=Color(0xFFFF0053),
//    onSecondaryContainer=Color(0xFFFF0053),
//    onTertiary=Color(0xFFFF0053),
//    tertiaryContainer=Color(0xFFFF0053),
//    onTertiaryContainer=Color(0xFFFF0053),
//    background=Color(0xFFFF0053),
//    onBackground=Color(0xFFFF0053),
//    surface=Color(0xFFFF0053),
//    onSurface=Color(0xFFFF0053),
//    surfaceVariant=Color(0xFFFF0053),
//    onSurfaceVariant=Color(0xFFFF0053),
//    surfaceTint=Color(0xFFFF0053),
//    inverseSurface=Color(0xFFFF0053),
//    inverseOnSurface=Color(0xFFFF0053),
//    error=Color(0xFFFF0053),
//    onError=Color(0xFFFF0053),
//    errorContainer=Color(0xFFFF0053),
//    onErrorContainer=Color(0xFFFF0053),
//    outline=Color(0xFFFF0053),
//    outlineVariant=Color(0xFFFF0053),
//    scrim=Color(0xFFFF0053),

)

//private val customColorScheme = lightColorScheme(
//    primary = Purple40,
//    secondary = PurpleGrey40,
//    tertiary = Pink40,
//    background = Color(0xFFFFFBFE),
//    surface = Color(0xFFFFFBFE),
//    onPrimary = Color.White,
//    onSecondary = Color.White,
//    onTertiary = Color.White,
//    onBackground = Color(0xFF1C1B1F),
//    onSurface = Color(0xFF1C1B1F),
//)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    customColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        customColor -> settingViewModel.getColors()
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> darkColorScheme
        else -> lightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}