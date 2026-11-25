package com.example.testapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged

class WorkshopJoinActivity : AppCompatActivity() {
    private lateinit var accessCodeInput: EditText
    private lateinit var errorMessageTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workshop_join)

        findViewById<View>(R.id.workshop_join_root).padForSystemBars()

        accessCodeInput = findViewById(R.id.access_code_input)
        errorMessageTextView = findViewById(R.id.access_code_error)
        val continueButton = findViewById<Button>(R.id.continue_button)

        // Typing again clears the previous validation error
        accessCodeInput.doAfterTextChanged { hideError() }

        continueButton.setOnClickListener {
            val accessCode = accessCodeInput.text.toString().trim()

            when {
                accessCode.isEmpty() -> showError(R.string.workshop_error_code_required)
                accessCode.length < MIN_CODE_LENGTH -> showError(R.string.workshop_error_code_too_short)
                accessCode != VALID_ACCESS_CODE -> showError(R.string.workshop_error_code_invalid)
                else -> {
                    hideError()
                    startActivity(Intent(this, WorkshopWelcomeActivity::class.java))
                }
            }
        }
    }

    private fun showError(messageRes: Int) {
        errorMessageTextView.text = getString(messageRes)
        errorMessageTextView.visibility = View.VISIBLE
        accessCodeInput.setBackgroundResource(R.drawable.workshop_input_error_background)
    }

    private fun hideError() {
        errorMessageTextView.visibility = View.GONE
        accessCodeInput.setBackgroundResource(R.drawable.workshop_input_background)
    }

    companion object {
        const val VALID_ACCESS_CODE = "123456"
        const val MIN_CODE_LENGTH = 6
    }
}
