package com.frag.weatherstatus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.frag.weatherstatus.ui.theme.Typography
import com.frag.weatherstatus.ui.theme.WeatherStatusTheme
import com.frag.weatherstatus.util.ScreenSize.Companion.getDisplayMetric
import com.frag.weatherstatus.view.Permissions
import com.frag.weatherstatus.view.WeatherView
import com.frag.weatherstatus.view.view.ViewRoute
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@ExperimentalPermissionsApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WeatherStatusTheme {
                Scaffold(modifier = Modifier.fillMaxSize() , backgroundColor = BACKGROUND_COLOR) {
                    rememberSystemUiController()
                        .setStatusBarColor(BACKGROUND_COLOR)
                    getDisplayMetric(context = application)
                    val rememberNavController = rememberNavController()
                    NavHost(navController = rememberNavController, startDestination = "${ViewRoute.Permission}"){
                        composable("${ViewRoute.Weather_view}"){
                            WeatherView()
                        }

                        composable("${ViewRoute.Permission}"){
                            Permissions(rememberNavController)
                        }

                    }
                }
            }
        }
    }
}
