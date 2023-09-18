package com.example.myapplication.data

import android.content.Context
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.MyApp
import com.example.myapplication.ui.theme.Pink40
import com.example.myapplication.ui.theme.Purple40
import com.example.myapplication.ui.theme.PurpleGrey40
import com.example.myapplication.ui.theme.lightColorScheme
import kotlinx.coroutines.launch

class SettingViewModel: ViewModel() {

    var isDarkThemeResponse:Boolean by mutableStateOf(getDrawerState())
    var customThemeSchemeResponse:ColorScheme by mutableStateOf(getColors())


    fun changeDrawerState(state: Boolean) {
        viewModelScope.launch {
            val sharedPref = MyApp.appContext.getSharedPreferences("myApp",Context.MODE_PRIVATE)
            with (sharedPref.edit()) {
                putBoolean("isDark", state)
                apply()
            }
            isDarkThemeResponse = state
        }
    }

    private fun getDrawerState(): Boolean{
        val sharedPref = MyApp.appContext.getSharedPreferences("myApp",Context.MODE_PRIVATE)
        return sharedPref.getBoolean("isDark", false)
    }

    fun getColors(): ColorScheme {
        val sharedPref = MyApp.appContext.getSharedPreferences("myApp", Context.MODE_PRIVATE)

        return lightColorScheme(
            primary = Color(sharedPref.getLong("primary", lightColorScheme().primary.value.toLong())),
            secondary = Color(sharedPref.getLong("secondary", lightColorScheme().secondary.value.toLong())),
            tertiary = Color(sharedPref.getLong("tertiary", lightColorScheme().tertiary.value.toLong())))

//        return lightColorScheme(
//            primary = Color(sharedPref.getLong("primary", lightColorScheme().primary.value.toLong())),
//            onPrimary = Color(sharedPref.getLong("onPrimary", lightColorScheme().onPrimary.value.toLong())),
//            primaryContainer = Color(sharedPref.getLong("primaryContainer", lightColorScheme().primaryContainer.value.toLong())),
//            onPrimaryContainer = Color(sharedPref.getLong("onPrimaryContainer", lightColorScheme().onPrimaryContainer.value.toLong())),
//            inversePrimary = Color(sharedPref.getLong("inversePrimary", lightColorScheme().inversePrimary.value.toLong())),
//            secondary = Color(sharedPref.getLong("secondary", lightColorScheme().secondary.value.toLong())),
//            onSecondary = Color(sharedPref.getLong("onSecondary", lightColorScheme().onSecondary.value.toLong())),
//            secondaryContainer = Color(sharedPref.getLong("secondaryContainer", lightColorScheme().secondaryContainer.value.toLong())),
//            onSecondaryContainer = Color(sharedPref.getLong("onSecondaryContainer", lightColorScheme().onSecondaryContainer.value.toLong())),
//            tertiary = Color(sharedPref.getLong("tertiary", lightColorScheme().tertiary.value.toLong())),
//            onTertiary = Color(sharedPref.getLong("onTertiary", lightColorScheme().onTertiary.value.toLong())),
//            tertiaryContainer = Color(sharedPref.getLong("tertiaryContainer", lightColorScheme().tertiaryContainer.value.toLong())),
//            onTertiaryContainer = Color(sharedPref.getLong("onTertiaryContainer", lightColorScheme().onTertiaryContainer.value.toLong())),
//            background = Color(sharedPref.getLong("background", lightColorScheme().background.value.toLong())),
//            onBackground = Color(sharedPref.getLong("onBackground", lightColorScheme().onBackground.value.toLong())),
//            surface = Color(sharedPref.getLong("surface", lightColorScheme().surface.value.toLong())),
//            onSurface = Color(sharedPref.getLong("onSurface", lightColorScheme().onSurface.value.toLong())),
//            surfaceVariant = Color(sharedPref.getLong("surfaceVariant", lightColorScheme().surfaceVariant.value.toLong())),
//            onSurfaceVariant = Color(sharedPref.getLong("onSurfaceVariant", lightColorScheme().onSurfaceVariant.value.toLong())),
//            surfaceTint = Color(sharedPref.getLong("surfaceTint", lightColorScheme().surfaceTint.value.toLong())),
//            inverseSurface = Color(sharedPref.getLong("inverseSurface", lightColorScheme().inverseSurface.value.toLong())),
//            inverseOnSurface = Color(sharedPref.getLong("inverseOnSurface", lightColorScheme().inverseOnSurface.value.toLong())),
//            error = Color(sharedPref.getLong("error", lightColorScheme().error.value.toLong())),
//            onError = Color(sharedPref.getLong("onError", lightColorScheme().onError.value.toLong())),
//            errorContainer = Color(sharedPref.getLong("errorContainer", lightColorScheme().errorContainer.value.toLong())),
//            onErrorContainer = Color(sharedPref.getLong("onErrorContainer", lightColorScheme().onErrorContainer.value.toLong())),
//            outline = Color(sharedPref.getLong("outline", lightColorScheme().outline.value.toLong())),
//            outlineVariant = Color(sharedPref.getLong("outlineVariant", lightColorScheme().outlineVariant.value.toLong())),
//            scrim = Color(sharedPref.getLong("scrim", lightColorScheme().scrim.value.toLong())))

    }

    fun setColors(colorScheme: ColorScheme) {
        val sharedPref = MyApp.appContext.getSharedPreferences("myApp", Context.MODE_PRIVATE)
        with (sharedPref.edit()) {
            putLong("primary", colorScheme.primary.value.toLong())
            putLong("onPrimary", colorScheme.onPrimary.value.toLong())
            putLong("primaryContainer", colorScheme.primaryContainer.value.toLong())
            putLong("onPrimaryContainer", colorScheme.onPrimaryContainer.value.toLong())
            putLong("inversePrimary", colorScheme.inversePrimary.value.toLong())
            putLong("secondary", colorScheme.secondary.value.toLong())
            putLong("onSecondary", colorScheme.onSecondary.value.toLong())
            putLong("secondaryContainer", colorScheme.secondaryContainer.value.toLong())
            putLong("onSecondaryContainer", colorScheme.onSecondaryContainer.value.toLong())
            putLong("tertiary", colorScheme.tertiary.value.toLong())
            putLong("onTertiary", colorScheme.onTertiary.value.toLong())
            putLong("tertiaryContainer", colorScheme.tertiaryContainer.value.toLong())
            putLong("onTertiaryContainer", colorScheme.onTertiaryContainer.value.toLong())
            putLong("background", colorScheme.background.value.toLong())
            putLong("onBackground", colorScheme.onBackground.value.toLong())
            putLong("surface", colorScheme.surface.value.toLong())
            putLong("onSurface", colorScheme.onSurface.value.toLong())
            putLong("surfaceVariant", colorScheme.surfaceVariant.value.toLong())
            putLong("onSurfaceVariant", colorScheme.onSurfaceVariant.value.toLong())
            putLong("surfaceTint", colorScheme.surfaceTint.value.toLong())
            putLong("inverseSurface", colorScheme.inverseSurface.value.toLong())
            putLong("inverseOnSurface", colorScheme.inverseOnSurface.value.toLong())
            putLong("error", colorScheme.error.value.toLong())
            putLong("onError", colorScheme.onError.value.toLong())
            putLong("errorContainer", colorScheme.errorContainer.value.toLong())
            putLong("onErrorContainer", colorScheme.onErrorContainer.value.toLong())
            putLong("outline", colorScheme.outline.value.toLong())
            putLong("outlineVariant", colorScheme.outlineVariant.value.toLong())
            putLong("scrim", colorScheme.scrim.value.toLong())
            apply()
        }
    }

}