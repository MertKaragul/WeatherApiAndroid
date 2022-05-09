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
    val main: FiveMain,
    val weather: List<Weather>,
    val clouds: Clouds,
    val wind: Wind,
    val visibility: Long,
    @SerializedName("pop")
    val pop: Double,
    val sys: Sys,
    val dt_txt: String
)


data class FiveMain(
    val temp : Double,
    val feels_like : Double,
    val temp_min : Double,
    val temp_max : Double,
    val pressure : Long,
    val sea_level : Long,
    val grnd_level : Long,
    val humidity : Long,
    val temp_kf : Double,
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




