package com.frag.weatherstatus.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.frag.weatherstatus.Date.WeatherDate
import com.frag.weatherstatus.Model.CurrentWeatherModel
import com.frag.weatherstatus.R
import com.frag.weatherstatus.mvvm.WeatherViewModel
import com.frag.weatherstatus.ui.theme.WeatherStatusTheme
import com.frag.weatherstatus.util.TextTypes
import com.frag.weatherstatus.util.TextTypes.Companion.bigText
import com.frag.weatherstatus.util.TextTypes.Companion.bodyText
import com.frag.weatherstatus.util.TextTypes.Companion.h1Text

@Composable
fun WeatherView(viewModels : WeatherViewModel = viewModel()){
    viewModels.getW()
    val getWeathers : CurrentWeatherModel? = viewModels._getWeathers.observeAsState().value

    Column(Modifier.fillMaxSize() , verticalArrangement = Arrangement.Top , horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            h1Text(text = "${getWeathers?.name}")
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