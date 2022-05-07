package com.frag.weatherstatus.mvvm

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.frag.weatherstatus.Model.*
import com.frag.weatherstatus.retrofit2.Retrofit2
import com.frag.weatherstatus.retrofit2.Retrofit2.Companion.retrofitBuilders
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.ViewModelScoped
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor() : ViewModel(){
    var _getWeathers : MutableLiveData<CurrentWeatherModel> = MutableLiveData()
    var getWeathersError : MutableLiveData<Boolean> = MutableLiveData(false)
    var weatherErrorText : MutableLiveData<String> = MutableLiveData("")
    var weatherLoading : MutableLiveData<Boolean> = MutableLiveData(false)


    //Five day variables
    val fiveWeather : MutableLiveData<FiveDayModel> = MutableLiveData()
    var fiveWeatherError : MutableLiveData<Boolean> = MutableLiveData(false)
    var fiveWeatherErrorText : MutableLiveData<String> = MutableLiveData("")
    var fiveWeatherLoading : MutableLiveData<Boolean> = MutableLiveData(false)

    @Inject
    fun getW(){
        weatherLoading.value = true
        retrofitBuilders.getWeather(lat = "35" , long = "139" , appid = "3c7c7fa5da2ec76d599bae0fca61d1af")
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<CurrentWeatherModel>(){
                override fun onSuccess(t: CurrentWeatherModel) {
                    _getWeathers.value = t
                    weatherLoading.value = false
                    Log.d("Viewmodel tag" , "$t")
                }
                override fun onError(e: Throwable) {
                    getWeathersError.value = true
                    weatherErrorText.value = e.localizedMessage
                    weatherLoading.value = false
                    Log.e("Viewmodel tag" , "$e")
                }
            })
    }

    @Inject
    fun getFiveDayWeatherStatus(){
        fiveWeatherLoading.value = true
        retrofitBuilders.getFiveDay(lat = "35" , long = "139" , appid = "3c7c7fa5da2ec76d599bae0fca61d1af")
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<FiveDayModel>(){
                override fun onSuccess(t: FiveDayModel) {
                    fiveWeather.value = t
                    fiveWeatherLoading.value = false

                    Log.d("WEATHERVİEWMODEL" , t.toString())
                }
                override fun onError(e: Throwable) {
                    fiveWeatherLoading.value = false
                    fiveWeatherError.value = true
                    fiveWeatherErrorText.value = e.localizedMessage
                }
            })
    }


}