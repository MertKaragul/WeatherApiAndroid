package com.frag.weatherstatus.mvvm

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.frag.weatherstatus.Model.*
import com.frag.weatherstatus.retrofit2.Retrofit2
import com.frag.weatherstatus.retrofit2.Retrofit2.Companion.retrofitBuilders
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class WeatherViewModel : ViewModel() {
    var _getWeathers = mutableStateOf<CurrentWeatherModel>(CurrentWeatherModel(Coord(lat = 0 , lon = 0) , base = "" , clouds = Clouds(all = 0) , cod = 0 , dt = 0 , id = 0 , main = Main(temp = 0.0 , feels_like = 0.0 , humidity = 0.0 , pressure = 0.0 , temp_max = 0.0 , temp_min = 0.0), name = "" , sys = Sys(type = 0 , id = 0 , country = "", message = 0.0 , sunrise = 0 , sunset = 0)  , timezone = 0 , visibility = 0 , weather = listOf() , wind = Wind(deg = 0, speed = 0.0)))

    init {
     getW()
    }

    private fun getW(){
        var getWeathersError by mutableStateOf(false)
        retrofitBuilders.getWeather(weatherType = "weather" ,lat = "35" , long = "139" , appid = "3c7c7fa5da2ec76d599bae0fca61d1af")
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<CurrentWeatherModel>(){
                override fun onSuccess(t: CurrentWeatherModel) {
                    _getWeathers.value = t
                }
                override fun onError(e: Throwable) {
                    getWeathersError = true
                }
            })
    }


}