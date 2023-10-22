package com.caolancode.weatherapp

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.caolancode.weatherapp.R
import com.caolancode.weatherapp.R.*
import com.caolancode.weatherapp.ui.theme.WeatherAppTheme
import com.caolancode.weatherapp.ui.theme.fontFamily

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .fillMaxSize()
            ){
                Header()
                Text(
                    text = "London",
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(top = 30.dp)
                    )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    DayCard("Today", 11.2, 4.8, "Moderate rain")
                    DayCard("Tomorrow", 21.37,12.8, "Sunny")
                    DayCard("Monday", 9.2, 4.2, "High wind")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header() {
    var location by remember {
        mutableStateOf("")
    }
    Row(
        modifier = Modifier
            .background(colorResource(id = color.navy))
            .fillMaxWidth()
            .padding(6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = "Weather App",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = fontFamily
        )
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(Color.White)
                .width(200.dp)
                .padding(start = 15.dp, end = 8.dp, top = 4.dp, bottom = 4.dp)
            ,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BasicTextField(
                value = location,
                onValueChange = { location = it},
                singleLine = true,
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = fontFamily,
                )
            )
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                tint = colorResource(id = color.navy)
            )
        }
        Image(
            painter = painterResource(id = drawable.google_icon),
            contentDescription = "Google logo",
            modifier = Modifier.clickable {
                /* TODO */
            }
        )
    }
}

@Composable
fun DayCard(day: String, highTemp: Double, lowTemp: Double, condition: String) {
    Card(
        modifier = Modifier
            .size(250.dp, 150.dp)
            .clip(shape = RoundedCornerShape(10.dp))
        ,
        elevation = CardDefaults.cardElevation(defaultElevation = 20.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.light_gray))
        ) {
            Text(
                text = day,
                modifier = Modifier
                    .background(colorResource(id = R.color.navy))
                    .fillMaxWidth()
                    .padding(top = 5.dp, bottom = 5.dp)
                ,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontFamily = fontFamily,
            )
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ){
                Icon(imageVector = Icons.Default.Warning, contentDescription = "weather icon")
                Column(
                    modifier = Modifier.width(50.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Text(text = highTemp.toString(), fontFamily = fontFamily)
                    Divider(color = Color.Black, thickness = 1.dp)
                    Text(text = lowTemp.toString(), fontFamily = fontFamily)
                }
            }
            Text(text = condition, fontFamily = fontFamily)
        }
    }
}