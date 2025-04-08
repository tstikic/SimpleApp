package com.example.testapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeScreen()
        }
    }
}

@Composable
fun ComposeScreen() {
    var showText = remember { mutableStateOf(false) }
    var inputText by remember { mutableStateOf("") }
    var submittedText by remember { mutableStateOf("") }

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
            contentDescription = "",
            modifier = Modifier
                .size(150.dp)
                .testTag(IMAGE_TEST_TAG)
        )

        Button(onClick = {
            // Toggle the visibility of the text when the button is clicked
            showText.value = !showText.value
        }) {
            Text(
                text = "Click Me",
                modifier = Modifier.testTag(BUTTON_TEXT_TEST_TAG)
            )
        }

        // Conditionally show the text when the button is clicked
        if (showText.value) {
            Text(
                "You clicked the button!",
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 20.dp)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        TextField(
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text("Type something") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            submittedText = inputText
        }) {
            Text("Submit Text")
        }

        // Display submitted text
        if (submittedText.isNotBlank()) {
            Text(
                text = "You typed: $submittedText",
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 20.dp)
            )
        }

    }
}

const val IMAGE_TEST_TAG = "udhufhufhu"
const val BUTTON_TEXT_TEST_TAG = "buttonTextTestTag"

@Preview(showBackground = true)
@Composable
fun PreviewComposeScreen() {
    ComposeScreen()
}
