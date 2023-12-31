

package com.plcoding.weatherapp.presentation
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.weatherapp.R

import kotlin.math.roundToInt

@Composable
fun WeatherCard(
     state: WeatherState,
     backgroundColor: Color,
     modifier: Modifier = Modifier
 ) {
    state.weatherInfo?.currentWeatherdata?.let { data ->
    Card (
        backgroundColor = backgroundColor,
        shape = RoundedCornerShape(30.dp),
        modifier = modifier.padding(40.dp)
        ){
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
                ){

            Spacer(modifier = Modifier.height(2.dp))

            Image(painter = painterResource(id = data.weatherType.iconRes),
                contentDescription = null,
                modifier = Modifier.width(50.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "${data.temperatureCelsius } °C",
                fontSize = 25.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = data.weatherType.weatherDesc,
                fontSize = 20.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                WeatherDataDisplay(
                    value = data.pressure.roundToInt(), 
                    unit = "hpa", 
                    icon = ImageVector.vectorResource(id = R.drawable.ic_pressure),
                    iconTint = Color.White,
                    textStyle = TextStyle(color = Color.White)
                
                )

                WeatherDataDisplay(
                    value = data.humidity.roundToInt(),
                    unit = "%",
                    icon = ImageVector.vectorResource(id = R.drawable.ic_drop),
                    iconTint = Color.White,
                    textStyle = TextStyle(color = Color.White)

                )

                WeatherDataDisplay(
                    value = data.windSpeed.roundToInt(),
                    unit = "km/h",
                    icon = ImageVector.vectorResource(id = R.drawable.ic_wind),
                    iconTint = Color.White,
                    textStyle = TextStyle(color = Color.White)

                )
            }



        }
    }
    }
}