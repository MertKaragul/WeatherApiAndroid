package com.frag.weatherstatus.util

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.frag.weatherstatus.fonts

class TextTypes {
    companion object{
        @Composable
        fun bodyText(text : String){
            val fontSize = (LocalDensity.current.fontScale * 15).sp
            Text(text = text , fontFamily = fonts , fontWeight = FontWeight.SemiBold , fontSize = fontSize)
        }

        @Composable
        fun h1Text(text : String , modifier : Modifier = Modifier){
            val fontSize = (LocalDensity.current.fontScale * 30).sp
            Text(text = text , fontFamily = fonts , fontWeight = FontWeight.Black , fontSize = fontSize , modifier = modifier)
        }

        @Composable
        fun bigText(text : String){
            val fontSize = (LocalDensity.current.fontScale * 70).sp
            Text(text = text , fontFamily = fonts , fontWeight = FontWeight.Black , fontSize = fontSize)
        }

    }
}