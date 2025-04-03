package com.example.testapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeScreen()
        }
    }

    @Composable
    fun ComposeScreen() {
        var showText = remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                "Welcome to Compose!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Image(
                painter = painterResource(id = R.drawable.image1),
                contentDescription = "Example Image",
                modifier = Modifier.size(150.dp)
            )

            Button(onClick = {
                // Toggle the visibility of the text when the button is clicked
                showText.value = !showText.value
            }) {
                Text("Click Me")
            }

            // Conditionally show the text when the button is clicked
            if (showText.value) {
                Text(
                    "You clicked the button!",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 20.dp)
                )
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewComposeScreen() {
        ComposeScreen()
    }
}