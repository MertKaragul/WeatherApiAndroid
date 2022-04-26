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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.frag.weatherstatus.util.ScreenSize

val API_KEY = ""

val URL = ""



val BACKGROUND_COLOR = Color(0xFF19C3FB)


@Composable
fun customButtom(getText : String , clicked : () -> (Unit)){
    OutlinedButton(onClick = { clicked() } , shape = RoundedCornerShape(30.dp) , modifier = Modifier
        .fillMaxWidth()
        .height((ScreenSize.screenHeight!! * 0.05).dp)
        .padding(start = 30.dp, end = 30.dp) , colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Unspecified , backgroundColor = Color.White)) {
        Text(getText)
    }
}

val fonts = FontFamily(
    Font(R.font.sourcesanspro_black , weight = FontWeight.Black),
    Font(R.font.sourcesanspro_bold , weight = FontWeight.Bold),
    Font(R.font.sourcesanspro_light , weight = FontWeight.Light),
    Font(R.font.sourcesanspro_semibold , weight = FontWeight.SemiBold),
)
