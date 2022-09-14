package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ComposeQuadrant()
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrant() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            QuadrantBlock(
                title = stringResource(R.string.quadrant1name),
                description = stringResource(R.string.quadrant1text),
                backgroundColor = Color.LightGray,
                modifier = Modifier.weight(1f)
            )
            QuadrantBlock(
                title = stringResource(R.string.quadrant2name),
                description = stringResource(R.string.quadrant2text),
                backgroundColor = Color.Blue,
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            QuadrantBlock(
                title = stringResource(R.string.quadrant3name),
                description = stringResource(R.string.quadrant3text),
                backgroundColor = Color.Yellow,
                modifier = Modifier.weight(1f)
            )
            QuadrantBlock(
                title = stringResource(R.string.quadrant4name),
                description = stringResource(R.string.quadrant4text),
                backgroundColor = Color.Green,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun QuadrantBlock(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
   Column(
       modifier = modifier
           .fillMaxSize()
           .background(backgroundColor)
           .padding(16.dp),
       horizontalAlignment = Alignment.CenterHorizontally,
       verticalArrangement = Arrangement.Center
   ) {
       Text(
           text = title,
           fontWeight = FontWeight.Bold,
           modifier = Modifier.padding(bottom = 16.dp)
       )
       Text(
           text = description,
           textAlign = TextAlign.Justify
       )
   }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrant()
    }
}