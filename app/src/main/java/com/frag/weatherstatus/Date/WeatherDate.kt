package com.frag.weatherstatus.Date

import android.util.Log
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class WeatherDate {
    private val TAG = "WEATHER_DATE"
    init{
        val localDateTime = LocalDateTime.now()
        val format1 = DateTimeFormatter.ofPattern("yyyy-MMMM-dd" , Locale.ENGLISH)
        val formatter = format1.format(localDateTime)

        Log.d(TAG , formatter)
    }
}