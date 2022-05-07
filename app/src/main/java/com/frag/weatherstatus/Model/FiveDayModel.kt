package com.frag.weatherstatus.Model

import android.opengl.Visibility
import com.google.gson.annotations.SerializedName

data class FiveDayModel(
    val cod: String,
    val message: Long,
    val cnt: Long,
    val list: List<FiveList>,
    val city: City
)

data class FiveList(
    val dt: Long,
    val main: Main,
    val weather: List<Weather>,
    val clouds: Clouds,
    val wind: Wind,
    val visibility: Long,
    val pop: Long,
    val sys: Sys,
    val dt_txt: String
)


data class City (
    val id: Long,
    val name: String,
    val coord: Cord,
    val country: String,
    val population: Long,
    val timezone: Long,
    val sunrise: Long,
    val sunset: Long
)

data class Cord (
    val lat: Double,
    val lon: Double
)




