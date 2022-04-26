package com.frag.weatherstatus.view

import android.os.CountDownTimer
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.frag.weatherstatus.R
import com.frag.weatherstatus.customButtom
import com.frag.weatherstatus.ui.theme.WeatherStatusTheme
import com.frag.weatherstatus.util.ScreenSize.Companion.screenHeight
import com.frag.weatherstatus.util.ScreenSize.Companion.screenWidth
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.PermissionStatus
import com.google.accompanist.permissions.rememberPermissionState


@ExperimentalPermissionsApi
@Composable
fun Permissions(rememberNavController: NavHostController) {
    val permission = rememberPermissionState(
        android.Manifest.permission.ACCESS_COARSE_LOCATION
    )

    when (permission.status) {
        PermissionStatus.Granted -> {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painterResource(id = R.drawable.ic_baseline_check_24),
                    contentDescription = "",
                    modifier = Modifier
                        .width((screenWidth!! * 0.5).dp)
                        .height((screenHeight!! * 0.3).dp)
                )
                Text("İzin verildi aktarılıyorsunuz...")

                rememberNavController.navigate("weather_view")
            }
        }
        is PermissionStatus.Denied -> {
            if((permission.status as PermissionStatus.Denied).shouldShowRationale){
                Column(horizontalAlignment = Alignment.CenterHorizontally , verticalArrangement = Arrangement.Center , modifier = Modifier.fillMaxSize()) {
                    Image(painterResource(id = R.drawable.ic_baseline_close_24) , contentDescription = "", modifier = Modifier
                        .width((screenWidth!! * 0.5).dp)
                        .height((screenHeight!! * 0.3).dp))
                    Text("Hey bu izini reddettiğinini görüyorum. Sana hava durumu hizmeti verebilmek için bu izini bana sağla lütfen." , modifier = Modifier.padding(10.dp) , fontSize = (LocalConfiguration.current.fontScale * 20).sp , textAlign = TextAlign.Center)
                    customButtom(getText = "İzin ver" , clicked = { permission.launchPermissionRequest() })
                }
            }else{
                RequestPermission(permission = permission)
            }
        }
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
private fun RequestPermission(permission : PermissionState){
    object : CountDownTimer(1000 , 1000){
        override fun onTick(p0: Long) {
            p0 / 1000
        }
        override fun onFinish() {
            permission.launchPermissionRequest()
        }
    }
}
