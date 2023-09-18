package com.example.myapplication.data

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.MyApp
import kotlinx.coroutines.launch

class SettingViewModel: ViewModel() {

    var isDarkThemeResponse:Boolean by mutableStateOf(getDrawerState())


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

}