package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}
@Composable
fun BusinessCardApp(){
    LogoNameAndTitle(
        imagePainter = painterResource(R.drawable.android_logo),
        fullName = stringResource(R.string.name),
        title = stringResource(R.string.jop_title))
}

// This fun is not to display the content,
// but to plan it on the screen and draw it
// in the sense of how it will appear
// and it does not have any data to draw.
// For example, this fun is the drawing for designing a house.
// This is not a house, but without it,
// you will not be able to build a house.
@Composable
private fun LogoNameAndTitle(imagePainter: Painter,
                     fullName: String,
                     modifier: Modifier = Modifier,
                     title: String){
    Column(modifier = modifier
        .background(color = Color(0, 100, 100))
        .padding(16.dp),
        Arrangement.Center,
        Alignment.CenterHorizontally) 
    {
        Image(painter = imagePainter,
            contentDescription = null,
            modifier
                .width(200.dp)
                .height(200.dp))
        Text(text = fullName,modifier.padding(top = 16.dp),
            fontSize = 40.sp, fontWeight = FontWeight.Bold, color = Color.White)
        Text(text = title,modifier.padding(bottom = 16.dp),fontSize = 25.sp,color = Color.Green)
    }
    Column(modifier.padding(16.dp), verticalArrangement = Arrangement.Bottom) {
        ContactInfo(iconPainter = Icons.Rounded.Email, info = stringResource(R.string.email))
        ContactInfo(iconPainter = Icons.Rounded.Call, info = stringResource(R.string.phone_number))
        ContactInfo(iconPainter = Icons.Rounded.Person, info = stringResource(R.string.github_account))
    }
}

@Composable
private fun ContactInfo(modifier: Modifier= Modifier, iconPainter: ImageVector, info: String){
    Column(modifier = modifier.padding(16.dp))
    {
        Row(modifier.padding(8.dp))
        {
            Image(imageVector = iconPainter, contentDescription = null)
            Text(text = info,modifier.padding(start = 16.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}