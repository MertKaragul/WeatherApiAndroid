package com.frag.weatherstatus.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import com.frag.weatherstatus.Date.WeatherDate
import com.frag.weatherstatus.Model.CurrentWeatherModel
import com.frag.weatherstatus.Model.FiveDayModel
import com.frag.weatherstatus.Model.Weather
import com.frag.weatherstatus.R
import com.frag.weatherstatus.mvvm.WeatherViewModel
import com.frag.weatherstatus.ui.theme.WeatherStatusTheme
import com.frag.weatherstatus.util.ScreenSize
import com.frag.weatherstatus.util.ScreenSize.Companion.screenHeight
import com.frag.weatherstatus.util.ScreenSize.Companion.screenWidth
import com.frag.weatherstatus.util.TextTypes
import com.frag.weatherstatus.util.TextTypes.Companion.bigText
import com.frag.weatherstatus.util.TextTypes.Companion.bodyText
import com.frag.weatherstatus.util.TextTypes.Companion.h1Text
import javax.inject.Inject

@Composable
fun WeatherView (weatherViewModel: WeatherViewModel = hiltViewModel() , date : WeatherDate = WeatherDate()){
    val getWeathers : CurrentWeatherModel? = weatherViewModel._getWeathers.value
    val fiveDay : MutableLiveData<FiveDayModel> = weatherViewModel.fiveWeather

    Column(Modifier.fillMaxSize() , verticalArrangement = Arrangement.Top , horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            getWeathers?.name?.let { h1Text(text = it) }
            bodyText(text = date.date)
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            bodyText(text = "${getWeathers?.sys?.country}")
            bodyText(text = "${getWeathers?.weather?.get(0)?.main}")
        }

        Column(modifier = Modifier.fillMaxWidth() , verticalArrangement = Arrangement.Center , horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painterResource(id = R.drawable.ic_sun) , contentDescription = null ,
                Modifier
                    .width((screenWidth!! * 1).dp)
                    .height((screenHeight!! * 0.4).dp) , alignment = Alignment.Center , contentScale = ContentScale.Fit)
            bigText(getWeathers?.main?.temp.toString()+"°C")
            Row(horizontalArrangement = Arrangement.Center , verticalAlignment = Alignment.CenterVertically){
                h1Text(text = getWeathers?.wind?.speed.toString())
                getWeathers?.wind?.deg.let {
                    if(it != null) Image(painter = painterResource(id = R.drawable.ic_baseline_arrow_upward_24) , contentDescription = "" , modifier = Modifier.rotate(it.toFloat()) )
                    else Image(painter = painterResource(id = R.drawable.ic_baseline_arrow_upward_24) , contentDescription = "" , modifier = Modifier.rotate(0F) )
                }
            }
        }

        LazyRow(horizontalArrangement = Arrangement.SpaceBetween , verticalAlignment = Alignment.CenterVertically , modifier = Modifier.fillMaxWidth()){
            item{
                if(weatherViewModel.fiveWeatherError.value == true){
                    Text("${weatherViewModel.fiveWeatherErrorText.value}" , fontSize = 10.sp)
                }else{
                    Text("no error")
                }
            }
        }
    }
}
