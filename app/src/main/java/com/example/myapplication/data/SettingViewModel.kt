package com.example.myapplication.data

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SettingViewModel constructor(helper: ThemeStateHelper): ViewModel() {

    var settingResponse:Boolean by mutableStateOf(true)

//    fun closeDrawer() {
//        helper.
//        viewModelScope.launch {
//
//            helper = false
//        }
//    }
//
//    fun openDrawer() {
//        viewModelScope.launch {
//            settingResponse = true
//        }
//    }
}