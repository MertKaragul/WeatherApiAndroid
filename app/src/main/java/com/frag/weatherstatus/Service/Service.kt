package com.frag.weatherstatus.Service

import com.frag.weatherstatus.Model.CurrentWeatherModel
import com.frag.weatherstatus.Model.FiveDayModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface Service {
    @GET("weather?units=metric")
    fun getWeather(@Query("lat") lat : String, @Query("lon") long : String, @Query("appid") appid : String) : Single<CurrentWeatherModel>

    @GET("forecast?units=metric")
    fun getFiveDay(@Query("lat") lat : String, @Query("lon") long : String, @Query("appid") appid : String) : Single<FiveDayModel>

}