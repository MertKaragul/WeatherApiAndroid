package com.frag.weatherstatus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.frag.weatherstatus.ui.theme.WeatherStatusTheme
import com.frag.weatherstatus.util.ScreenSize.Companion.getDisplayMetric
import com.frag.weatherstatus.view.Permissions
import com.frag.weatherstatus.view.WeatherView
import com.google.accompanist.permissions.ExperimentalPermissionsApi


@ExperimentalPermissionsApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherStatusTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = BACKGROUND_COLOR
                ) {
                    getDisplayMetric(context = application)
                    val rememberNavController = rememberNavController()
                    NavHost(navController = rememberNavController, startDestination = "permissions"){
                        composable("permissions"){
                            Permissions(rememberNavController)
                        }
                        composable("weather_view"){
                            WeatherView()
                        }
                    }
                }
            }
        }
    }
}
