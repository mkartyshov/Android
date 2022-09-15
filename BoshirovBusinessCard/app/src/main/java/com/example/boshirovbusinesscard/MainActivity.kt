package com.example.boshirovbusinesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.boshirovbusinesscard.ui.theme.BoshirovBusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoshirovBusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    CardComposeApp()
                }
            }
        }
    }
}

@Composable
fun CardComposeApp() {
    Column() {
        Row() {
            Info(
                name = stringResource(R.string.name),
                organization = stringResource(R.string.organization),
                jobTitle = stringResource(R.string.job_title),
                photo = painterResource(R.drawable.boshirov),
                logo = painterResource(R.drawable.gru)
            )
        }
        Row() {
            Contacts(
                phone = stringResource(R.string.phone),
                social = stringResource(R.string.instagram),
                email = stringResource(R.string.email),
                pLogo = painterResource(R.drawable.ic_baseline_local_phone_24),
                sLogo = painterResource(R.drawable.ic_baseline_photo_24),
                eLogo = painterResource(R.drawable.ic_baseline_email_24)
            )
        }
    }
}

@Composable
private fun Info(
    name: String,
    organization: String,
    jobTitle: String,
    photo: Painter,
    logo: Painter
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top) {
        Row {
            Image(
                painter = logo,
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 10.dp, top = 50.dp, bottom = 10.dp, end = 10.dp)
            )
            Image(
                painter = photo,
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 10.dp, top = 50.dp, bottom = 10.dp, end = 10.dp)
            )
        }
        Row {
            Text(
                text = name,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

        }
        Row {
            Text(
                text = organization,
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Row {
            Text(
                text = jobTitle,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 50.dp)
            )
        }
    }
}

@Composable
private fun Contacts(
    phone: String,
    social: String,
    email: String,
    pLogo: Painter,
    sLogo: Painter,
    eLogo: Painter
) {
    Column(verticalArrangement = Arrangement.Bottom) {
        Row {
            Image(
                painter = pLogo,
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 10.dp, bottom = 15.dp)
            )
            Text(
                text = phone,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .padding(bottom = 15.dp)
            )
        }
        Row {
            Image(
                painter = sLogo,
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 10.dp, bottom = 15.dp)
            )
            Text(
                text = social,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .padding(bottom = 15.dp)
            )
        }
        Row {
            Image(
                painter = eLogo,
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 10.dp, bottom = 15.dp)
            )
            Text(
                text = email,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .padding(bottom = 50.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BoshirovBusinessCardTheme {
        CardComposeApp()
    }
}