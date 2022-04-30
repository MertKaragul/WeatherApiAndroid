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
    var _getWeathers : MutableLiveData<CurrentWeatherModel> = MutableLiveData()
    var getWeathersError : MutableLiveData<Boolean> = MutableLiveData(false)

     fun getW(){
        retrofitBuilders.getWeather(weatherType = "weather" ,lat = "35" , long = "139" , appid = "3c7c7fa5da2ec76d599bae0fca61d1af")
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<CurrentWeatherModel>(){
                override fun onSuccess(t: CurrentWeatherModel) {
                    _getWeathers.value = t

                    Log.d("Viewmodel tag" , "$t")
                }
                override fun onError(e: Throwable) {
                    getWeathersError.value = false
                    Log.e("Viewmodel tag" , "$e")
                }
            })
    }
}