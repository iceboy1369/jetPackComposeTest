package com.example.myapplication.data

import android.content.Context

class ThemeStateHelper constructor(private val  context: Context) {

    fun isDarkTheme(): Boolean {
        val sharedPref = context.getSharedPreferences("myApp",Context.MODE_PRIVATE)
        return sharedPref.getBoolean("isDark",false)
    }

    fun setDarkTheme(state: Boolean){
        val sharedPref = context.getSharedPreferences("myApp",Context.MODE_PRIVATE)
        with (sharedPref.edit()) {
            putBoolean("isDark", state)
            apply()
        }
    }
}