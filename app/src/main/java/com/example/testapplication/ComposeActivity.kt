package com.example.testapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ComposeActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                ComposeScreen(onNotificationClick = {
                    val intent = Intent(this, NotificationsActivity::class.java)
                    startActivity(intent)
                })
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposeScreen(onNotificationClick: () -> Unit) {
    var inputText by remember { mutableStateOf("") }
    var submittedText by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize().background(AppBackgroundGradient)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                "Welcome to Compose!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = OnDarkPrimary
            )

            Spacer(modifier = Modifier.height(20.dp))

            Image(
                painter = painterResource(id = R.drawable.compose_testing),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 350.dp, height = 150.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .testTag(IMAGE_TEST_TAG)
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = inputText,
                onValueChange = { inputText = it },
                label = { Text("Type something") },
                shape = RoundedCornerShape(14.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = OnDarkPrimary,
                    focusedLabelColor = OnDarkPrimary,
                    unfocusedLabelColor = OnDarkSecondary,
                    focusedBorderColor = OnDarkPrimary,
                    unfocusedBorderColor = OnDarkSecondary,
                    cursorColor = OnDarkPrimary
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedButton(
                onClick = { submittedText = inputText },
                shape = RoundedCornerShape(24.dp),
                border = BorderStroke(1.5.dp, OnDarkPrimary),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = OnDarkPrimary),
                modifier = Modifier.height(52.dp)
            ) {
                Text("Submit Text")
            }

            if (submittedText.isNotBlank()) {
                Text(
                    text = "You typed: $submittedText",
                    fontSize = 18.sp,
                    color = OnDarkPrimary,
                    modifier = Modifier.padding(top = 20.dp)
                )
            }

            Spacer(modifier = Modifier.height(56.dp))

            Text(
                "Click this button to open next screen:",
                fontSize = 15.sp,
                color = OnDarkSecondary
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onNotificationClick,
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
            ) {
                Text(text = "Click Me", modifier = Modifier.testTag(BUTTON_TEXT_TEST_TAG))
            }
        }
    }
}

const val IMAGE_TEST_TAG = "imageTestTag"
const val BUTTON_TEXT_TEST_TAG = "buttonTextTestTag"

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun PreviewComposeScreen() {
    AppTheme {
        ComposeScreen(onNotificationClick = {})
    }
}
