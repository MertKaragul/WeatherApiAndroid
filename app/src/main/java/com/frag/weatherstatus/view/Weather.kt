package com.frag.weatherstatus.view

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.annotation.MainThread
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.viewmodel.compose.viewModel
import com.frag.weatherstatus.Model.CurrentWeatherModel
import com.frag.weatherstatus.Model.Sys
import com.frag.weatherstatus.R
import com.frag.weatherstatus.fonts
import com.frag.weatherstatus.mvvm.WeatherViewModel
import com.frag.weatherstatus.ui.theme.WeatherStatusTheme
import com.frag.weatherstatus.util.ScreenSize
import com.frag.weatherstatus.util.ScreenSize.Companion.screenHeight
import com.frag.weatherstatus.util.ScreenSize.Companion.screenWidth
import com.frag.weatherstatus.util.TextTypes
import com.frag.weatherstatus.util.TextTypes.Companion.bigText
import com.frag.weatherstatus.util.TextTypes.Companion.bodyText
import com.frag.weatherstatus.retrofit2.Retrofit2
import com.frag.weatherstatus.retrofit2.Retrofit2.Companion.retrofitBuilders
import com.frag.weatherstatus.util.TextTypes.Companion.h1Text
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.flow.asStateFlow

@Composable
fun WeatherView(viewModels : WeatherViewModel = viewModel()){
    val weatherViewModel = WeatherViewModel()
    val rememberValue = remember { weatherViewModel._getWeathers }

    Column(Modifier.fillMaxSize() , verticalArrangement = Arrangement.Top , horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            viewModels._getWeathers.value.name.let { h1Text(text = "$it") }
            bodyText(text = "14 Nisan Salı")
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            bodyText(text = "United States")
            bodyText(text = "Clear")

        }

        Column(modifier = Modifier.fillMaxWidth() , verticalArrangement = Arrangement.Center , horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painterResource(id = R.drawable.ic_clear) , contentDescription = null ,
                Modifier
                    .width(300.dp)
                    .height(300.dp) , alignment = Alignment.Center , contentScale = ContentScale.Crop)
            bigText("7°C")
            TextTypes.h1Text(text = "Wind")
        }

        LazyRow(horizontalArrangement = Arrangement.SpaceBetween , verticalAlignment = Alignment.CenterVertically , modifier = Modifier.fillMaxWidth()){
            items(6){
                Column(horizontalAlignment = Alignment.CenterHorizontally , verticalArrangement = Arrangement.Center) {
                    Image(painterResource(id = R.drawable.ic_clear) , contentDescription = "" , modifier = Modifier
                        .width(20.dp)
                        .height(20.dp))
                    Text("Clear")
                }
            }
        }
    }
}



@Preview
@Composable
fun Preview_Weather(){
    WeatherStatusTheme {
        WeatherView()
    }
}