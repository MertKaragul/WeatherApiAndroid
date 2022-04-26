package com.frag.weatherstatus.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.frag.weatherstatus.R

@Composable
fun WeatherView(){
    Column(modifier = Modifier.fillMaxSize()) {
        Image(painterResource(id = R.drawable.ic_baseline_close_24) , contentDescription = "" , modifier = Modifier.width(10.dp).height(10.dp))
        Text("Hi welcome weather status view" , fontSize = 30.sp , color = Color.White)
    }
}