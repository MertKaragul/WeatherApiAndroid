package com.frag.weatherstatus.Model

import com.google.gson.annotations.SerializedName

data class CurrentWeatherModel(
    @SerializedName("coord")
    val cord : Coord,
    @SerializedName("weather")
    val weather : List<Weather>?,
    @SerializedName("base")
    val base : String?,
    @SerializedName("main")
    val main : Main?,
    @SerializedName("visibility")
    val visibility : Int?,
    @SerializedName("wind")
    val wind : Wind?,
    @SerializedName("clouds")
    val clouds: Clouds?,
    @SerializedName("dt")
    val dt : Int?,
    @SerializedName("sys")
    val sys : Sys?,
    @SerializedName("timezone")
    val timezone : Int?,
    @SerializedName("id")
    val id : Int?,
    @SerializedName("name")
    val name : String?,
    @SerializedName("cod")
    val cod : Int?

)
data class Coord(
    val lon : Long?,
    val lat : Long?
)
data class Weather(
    val id : Int?,
    val main : String?,
    val description : String?,
    val icon : String?,
)
data class Main(
    val temp : Double?,
    val feels_like : Double?,
    val temp_min : Double?,
    val temp_max : Double?,
    val pressure : Double?,
    val humidity : Double?,
)

data class Wind(
    val speed : Double?,
    val deg : Float?
)

data class Clouds(
    val all : Int?
)

data class Sys (
    val type : Int?,
    val id : Int?,
    val message : Double?,
    val country : String?,
    val sunrise : Int?,
    val sunset : Int?
)
