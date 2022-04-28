package com.frag.weatherstatus.Service

import com.frag.weatherstatus.Model.CurrentWeatherModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface Service {
    @GET("{weatherType}?units=metric")
    fun getWeather(@Path("weatherType") weatherType : String ,  @Query("lat") lat : String, @Query("lon") long : String, @Query("appid") appid : String) : Single<CurrentWeatherModel>
}