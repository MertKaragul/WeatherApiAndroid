package com.frag.weatherstatus

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.frag.weatherstatus.util.ScreenSize

val API_KEY = ""

val URL = ""



val BACKGROUND_COLOR = Color(0xFFFFB700)


@Composable
fun customButtom(getText : String , clicked : () -> (Unit)){
    OutlinedButton(onClick = { clicked() } , shape = RoundedCornerShape(30.dp) , modifier = Modifier
        .fillMaxWidth()
        .height((ScreenSize.screenHeight!! * 0.05).dp)
        .padding(start = 30.dp, end = 30.dp) , colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Unspecified , backgroundColor = Color.White)) {
        Text(getText)
    }
}