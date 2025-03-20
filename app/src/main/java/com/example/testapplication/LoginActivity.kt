package com.example.testapplication
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class LoginActivity : AppCompatActivity() {
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var errorMessageTextView: TextView
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize UI components
        usernameEditText = findViewById<EditText>(R.id.username)
        passwordEditText = findViewById<EditText>(R.id.password)
        errorMessageTextView = findViewById<TextView>(R.id.error_message)
        loginButton = findViewById<Button>(R.id.login_button)

        // Set click listener for login button
        loginButton.setOnClickListener(View.OnClickListener {
            val username = usernameEditText.getText().toString()
            val password = passwordEditText.getText().toString()

            // Simple login check
            if (username == "admin" && password == "1234") {
                // Login successful, navigate to homepage
                val intent = Intent(
                    this@LoginActivity,
                    HomeActivity::class.java
                )
                startActivity(intent)
                finish()
            } else {
                // Show error message
                errorMessageTextView.setVisibility(View.VISIBLE)
            }
        })
    }
}
