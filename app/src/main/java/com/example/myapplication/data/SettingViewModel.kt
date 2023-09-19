package com.example.myapplication.data

import android.content.Context
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.MyApp
import com.example.myapplication.ui.theme.background
import com.example.myapplication.ui.theme.errorContainer
import com.example.myapplication.ui.theme.inverseOnSurface
import com.example.myapplication.ui.theme.inversePrimary
import com.example.myapplication.ui.theme.inverseSurface
import com.example.myapplication.ui.theme.onBackground
import com.example.myapplication.ui.theme.onError
import com.example.myapplication.ui.theme.onErrorContainer
import com.example.myapplication.ui.theme.onPrimary
import com.example.myapplication.ui.theme.onPrimaryContainer
import com.example.myapplication.ui.theme.onSecondary
import com.example.myapplication.ui.theme.onSecondaryContainer
import com.example.myapplication.ui.theme.onSurface
import com.example.myapplication.ui.theme.onSurfaceVariant
import com.example.myapplication.ui.theme.onTertiary
import com.example.myapplication.ui.theme.onTertiaryContainer
import com.example.myapplication.ui.theme.outline
import com.example.myapplication.ui.theme.outlineVariant
import com.example.myapplication.ui.theme.primary
import com.example.myapplication.ui.theme.primaryContainer
import com.example.myapplication.ui.theme.scrim
import com.example.myapplication.ui.theme.secondary
import com.example.myapplication.ui.theme.secondaryContainer
import com.example.myapplication.ui.theme.settingViewModel
import com.example.myapplication.ui.theme.surface
import com.example.myapplication.ui.theme.surfaceTint
import com.example.myapplication.ui.theme.surfaceVariant
import com.example.myapplication.ui.theme.tertiary
import com.example.myapplication.ui.theme.tertiaryContainer
import kotlinx.coroutines.launch

class SettingViewModel: ViewModel() {

    var themeStateResponse:Int by mutableIntStateOf(getDrawerState())
    var customThemeSchemeResponse: ColorScheme by mutableStateOf(getColors())

    fun changeDrawerState(state: Int) {
        viewModelScope.launch {
            val sharedPref = MyApp.appContext.getSharedPreferences("myApp",Context.MODE_PRIVATE)
            with (sharedPref.edit()) {
                putInt("theme", state)
                apply()
            }
            themeStateResponse = state
        }
    }


    private fun getDrawerState(): Int{
        val sharedPref = MyApp.appContext.getSharedPreferences("myApp",Context.MODE_PRIVATE)
        return sharedPref.getInt("theme", 0)
    }

    private fun getColors(): ColorScheme{
        val sharedPref = MyApp.appContext.getSharedPreferences("myApp", Context.MODE_PRIVATE)

        return lightColorScheme(
            primary = Color(sharedPref.getString("primary",  primary.value.toString())!!.toULong()),
            onPrimary = Color(sharedPref.getString("onPrimary", onPrimary.value.toString())!!.toULong()),
            secondary = Color(sharedPref.getString("secondary", secondary.value.toString())!!.toULong()),
            onSecondary = Color(sharedPref.getString("onSecondary", onSecondary.value.toString())!!.toULong()),
            tertiary = Color(sharedPref.getString("tertiary", tertiary.value.toString())!!.toULong()),
            onTertiary = Color(sharedPref.getString("onTertiary", onTertiary.value.toString())!!.toULong()),
            background = Color(sharedPref.getString("background", background.value.toString())!!.toULong()),
            onBackground = Color(sharedPref.getString("onBackground", onBackground.value.toString())!!.toULong()),
            primaryContainer = Color(sharedPref.getString("primaryContainer", primaryContainer.value.toString())!!.toULong()),
            onPrimaryContainer = Color(sharedPref.getString("onPrimaryContainer", onPrimaryContainer.value.toString())!!.toULong()),
            inversePrimary = Color(sharedPref.getString("inversePrimary", inversePrimary.value.toString())!!.toULong()),
            secondaryContainer = Color(sharedPref.getString("secondaryContainer", secondaryContainer.value.toString())!!.toULong()),
            onSecondaryContainer = Color(sharedPref.getString("onSecondaryContainer", onSecondaryContainer.value.toString())!!.toULong()),
            tertiaryContainer = Color(sharedPref.getString("tertiaryContainer", tertiaryContainer.value.toString())!!.toULong()),
            onTertiaryContainer = Color(sharedPref.getString("onTertiaryContainer", onTertiaryContainer.value.toString())!!.toULong()),
            surface = Color(sharedPref.getString("surface", surface.value.toString())!!.toULong()),
            onSurface = Color(sharedPref.getString("onSurface", onSurface.value.toString())!!.toULong()),
            surfaceVariant = Color(sharedPref.getString("surfaceVariant", surfaceVariant.value.toString())!!.toULong()),
            onSurfaceVariant = Color(sharedPref.getString("onSurfaceVariant", onSurfaceVariant.value.toString())!!.toULong()),
            surfaceTint = Color(sharedPref.getString("surfaceTint", surfaceTint.value.toString())!!.toULong()),
            inverseSurface = Color(sharedPref.getString("inverseSurface", inverseSurface.value.toString())!!.toULong()),
            inverseOnSurface = Color(sharedPref.getString("inverseOnSurface", inverseOnSurface.value.toString())!!.toULong()),
            error = Color(sharedPref.getString("error", com.example.myapplication.ui.theme.error.value.toString())!!.toULong()),
            onError = Color(sharedPref.getString("onError", onError.value.toString())!!.toULong()),
            errorContainer = Color(sharedPref.getString("errorContainer", errorContainer.value.toString())!!.toULong()),
            onErrorContainer = Color(sharedPref.getString("onErrorContainer", onErrorContainer.value.toString())!!.toULong()),
            outline = Color(sharedPref.getString("outline", outline.value.toString())!!.toULong()),
            outlineVariant = Color(sharedPref.getString("outlineVariant", outlineVariant.value.toString())!!.toULong()),
            scrim = Color(sharedPref.getString("scrim", scrim.value.toString())!!.toULong())
        )

    }

    fun setColors(colorScheme: ColorScheme) {
        val sharedPref = MyApp.appContext.getSharedPreferences("myApp", Context.MODE_PRIVATE)
        with (sharedPref.edit()) {
            putString("primary", colorScheme.primary.value.toString())
            putString("onPrimary", colorScheme.onPrimary.value.toString())
            putString("secondary", colorScheme.secondary.value.toString())
            putString("onSecondary", colorScheme.onSecondary.value.toString())
            putString("tertiary", colorScheme.tertiary.value.toString())
            putString("onTertiary", colorScheme.onTertiary.value.toString())
            putString("background", colorScheme.background.value.toString())
            putString("onBackground", colorScheme.onBackground.value.toString())
            putString("primaryContainer", colorScheme.primaryContainer.value.toString())
            putString("onPrimaryContainer", colorScheme.onPrimaryContainer.value.toString())
            putString("inversePrimary", colorScheme.inversePrimary.value.toString())
            putString("secondaryContainer", colorScheme.secondaryContainer.value.toString())
            putString("onSecondaryContainer", colorScheme.onSecondaryContainer.value.toString())
            putString("tertiaryContainer", colorScheme.tertiaryContainer.value.toString())
            putString("onTertiaryContainer", colorScheme.onTertiaryContainer.value.toString())
            putString("surface", colorScheme.surface.value.toString())
            putString("onSurface", colorScheme.onSurface.value.toString())
            putString("surfaceVariant", colorScheme.surfaceVariant.value.toString())
            putString("onSurfaceVariant", colorScheme.onSurfaceVariant.value.toString())
            putString("surfaceTint", colorScheme.surfaceTint.value.toString())
            putString("inverseSurface", colorScheme.inverseSurface.value.toString())
            putString("inverseOnSurface", colorScheme.inverseOnSurface.value.toString())
            putString("error", colorScheme.error.value.toString())
            putString("onError", colorScheme.onError.value.toString())
            putString("errorContainer", colorScheme.errorContainer.value.toString())
            putString("onErrorContainer", colorScheme.onErrorContainer.value.toString())
            putString("outline", colorScheme.outline.value.toString())
            putString("outlineVariant", colorScheme.outlineVariant.value.toString())
            putString("scrim", colorScheme.scrim.value.toString())
            apply()
        }
        customThemeSchemeResponse = settingViewModel.getColors()
    }

}