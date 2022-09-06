package com.example.independencedaycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.independencedaycard.ui.theme.IndependenceDayCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IndependenceDayCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                }
            }
        }
    }
}

@Composable
fun GreetingWithText(message: String, from: String) {
    Text(
        text = message,
        fontSize = 30.sp
    )
    Text(
        text = from,
        fontSize = 20.sp
    )
}

@Preview(showBackground = false)
@Composable
fun IndependencePreview() {
    IndependenceDayCardTheme {
        GreetingWithText("Happy Independence Day!", "- from Mikhail")
    }
}