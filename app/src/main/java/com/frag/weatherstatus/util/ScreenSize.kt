package com.frag.weatherstatus.util

import android.app.Application
import android.content.Context
import androidx.compose.ui.platform.LocalConfiguration

class ScreenSize() {
    companion object{
        var screenWidth : Float ?= null
        var screenHeight : Float ?= null
        fun getDisplayMetric(context: Application){
           val displayMetric = context.resources.displayMetrics
            (displayMetric.heightPixels / displayMetric.density).let {
                screenHeight = it
            }

            (displayMetric.widthPixels / displayMetric.density).let {
                screenWidth = it
            }
        }
    }


}