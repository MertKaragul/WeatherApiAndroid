package com.frag.weatherstatus.view.WeatherViews

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.frag.weatherstatus.R
import com.frag.weatherstatus.customButtom
import com.frag.weatherstatus.mvvm.WeatherViewModel
import com.frag.weatherstatus.util.ScreenSize
import com.frag.weatherstatus.util.TextTypes.Companion.h1Text

@Composable
fun WeatherErrView(weatherViewModel: WeatherViewModel) {
    val weatherErrorText = weatherViewModel.weatherErrorText.observeAsState().value
    val weatherLoadingStatus = weatherViewModel.weatherLoading.observeAsState().value
    val weatherError = weatherViewModel.getWeathersError.observeAsState().value

    Column(modifier = Modifier.fillMaxSize() , horizontalAlignment = Alignment.CenterHorizontally , verticalArrangement = Arrangement.Center) {
        if(weatherLoadingStatus == true){
            CircularProgressIndicator(color = Color.White)
        }else if(weatherLoadingStatus == false){
            Image(painterResource(id = R.drawable.ic_error) , contentDescription = "" , modifier = Modifier
                .width((ScreenSize.screenWidth!! * 0.3).dp)
                .height((ScreenSize.screenHeight!! * 0.2).dp))
            h1Text(text = "$weatherErrorText")
            customButtom("Tekrar Dene" , clicked = { weatherViewModel.getW() })

            if(weatherError == true){

            }
        }
    }
}