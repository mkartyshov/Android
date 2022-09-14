package com.example.ericcartman

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ericcartman.ui.theme.EricCartmanTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EricCartmanTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    BiographyApp()
                }
            }
        }
    }
}

@Composable
fun BiographyApp() {
    BiographyWithImage(
        name = stringResource(R.string.name_text),
        info = stringResource(R.string.info_text),
        bio = stringResource(R.string.bio_text),
        image = painterResource(R.drawable.header)
    )
}

@Composable
private fun BiographyWithImage(name: String, info: String, bio: String, image: Painter) {
    Column {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = name,
            fontSize = 30.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = info,
            textAlign = TextAlign.Justify,
            fontSize = 25.sp,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = bio,
            textAlign = TextAlign.Justify,
            fontSize = 20.sp,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EricCartmanTheme {
        BiographyApp()
    }
}