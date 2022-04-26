package com.frag.weatherstatus.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.frag.weatherstatus.R
import com.frag.weatherstatus.fonts
import com.frag.weatherstatus.ui.theme.WeatherStatusTheme
import com.frag.weatherstatus.util.ScreenSize
import com.frag.weatherstatus.util.ScreenSize.Companion.screenHeight
import com.frag.weatherstatus.util.ScreenSize.Companion.screenWidth

@Composable
fun WeatherView(){
    val fontCurrent = LocalDensity.current.fontScale

    Column(Modifier.fillMaxSize() , verticalArrangement = Arrangement.Top , horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "New York",
                fontFamily = fonts,
                fontWeight = FontWeight.Black,
                fontSize = (fontCurrent * 30).sp
            )
            Text(
                "15 Nisan Çarşamba",
                fontFamily = fonts,
                fontWeight = FontWeight.SemiBold,
                fontSize = (fontCurrent * 15).sp
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "United State",
                fontFamily = fonts,
                fontWeight = FontWeight.SemiBold,
                fontSize = (fontCurrent * 15).sp
            )
            Text(
                "Clear",
                fontFamily = fonts,
                fontWeight = FontWeight.SemiBold,
                fontSize = (fontCurrent * 15).sp
            )
        }

        Column(modifier = Modifier.fillMaxWidth() , verticalArrangement = Arrangement.Center , horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painterResource(id = R.drawable.ic_clear) , contentDescription = null , Modifier.width((screenWidth!! * 0.3).dp).height((screenHeight!! * 0.3).dp) , alignment = Alignment.Center , contentScale = ContentScale.Crop)
            Text("7℃" , fontFamily = fonts , fontWeight = FontWeight.SemiBold , fontSize = (fontCurrent * 70).sp)
            Text("")
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