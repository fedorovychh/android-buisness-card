package com.example.android_buisness_card

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_buisness_card.ui.theme.AndroidbuisnesscardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidbuisnesscardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }
    }
}

@Composable
fun BusinessCard(
    name: String,
    text: String,
    background: Color,
    phone: String,
    email: String
) {
    Box(
        modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.android_color_2))
    ) {
        Box (
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            )  {
                AndroidLogoImage(background = background)
                FullNameText(name = name)
                TitleText(text = text)
            }
        }

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Column (Modifier.padding(bottom = 16.dp)) {
                Row (Modifier.padding(6.dp), verticalAlignment = Alignment.CenterVertically) {
                    LogoIcon(painterResource(id = R.drawable.baseline_perm_phone_msg_black_24dp))
                    DefaultText(text = phone)
                }

                Row (Modifier.padding(6.dp), verticalAlignment = Alignment.CenterVertically) {
                    LogoIcon(painterResource(id = R.drawable.baseline_outgoing_mail_black_24dp))
                    DefaultText(text = email)
                }
            }
        }
    }
}

@Composable
private fun LogoIcon(painter: Painter) {
    Icon(
        painter = painter,
        contentDescription = null,
        Modifier.padding(end = 6.dp),
        LocalContentColor.current.copy(alpha = 0.5F)
    )
}

@Composable
private fun DefaultText(text: String) {
    Text(
        text = text,
        color = colorResource(id = R.color.android_color),
    )
}

@Composable
private fun AndroidLogoImage(background: Color) {
    Image(
        painter = painterResource(id = R.drawable.android_logo),
        contentDescription = null,
        modifier = Modifier
            .background(background)
            .width(150.dp)
    )
}

@Composable
private fun FullNameText(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        fontFamily = FontFamily.Monospace,
        textAlign = TextAlign.Center,
        color = colorResource(id = R.color.android_color),
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier
            .padding(6.dp)
    )
}

@Composable
private fun TitleText(text: String) {
    Text(
        text = text,
        textAlign = TextAlign.Center,
        color = colorResource(id = R.color.teal_700),
        fontWeight = FontWeight.Bold
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidbuisnesscardTheme {
        BusinessCard(
            name = "Jennifer Doe",
            text = "Android Developer Extraordinaire",
            colorResource(id = R.color.android_color),
            phone = "+ 11 (123) 444 55 66",
            email = "jen.doe@android.com"
        )
    }
}
