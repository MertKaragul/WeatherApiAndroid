package com.frag.weatherstatus.view

import androidx.compose.runtime.Composable
import com.frag.weatherstatus.mvvm.WeatherViewModel
import com.frag.weatherstatus.view.WeatherViews.WeatherErrView

@Composable
fun WeatherErrStatusCheck(provideWeatherViewModels : WeatherViewModel){
    if(provideWeatherViewModels.getWeathersError.value == true) WeatherErrView(provideWeatherViewModels)
    else WeatherView(provideWeatherViewModels)
}