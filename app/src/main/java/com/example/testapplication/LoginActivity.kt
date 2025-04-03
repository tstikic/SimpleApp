package com.example.testapplication
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class LoginActivity : AppCompatActivity() {
    private lateinit var login_button: Button
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var errorMessageTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.setContentView(R.layout.activity_login)
        //showHome()

        login_button = findViewById(R.id.login_button)
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        errorMessageTextView = findViewById(R.id.error_message)


        login_button.setOnClickListener {
            errorMessageTextView.visibility = View.GONE


            if (username.text.toString().isEmpty()) {
                errorMessageTextView.visibility = View.GONE
                username.error = getString(R.string.empty_username)
                username.requestFocus()
            } else
                if (password.text.toString().isEmpty()) {
                    errorMessageTextView.visibility = View.GONE
                    password.error = getString(R.string.empty_password)
                    password.requestFocus()
                } else
                    if (username.text.toString() == "Admin" && password.text.toString() == "123456") {
                        errorMessageTextView.visibility = View.GONE
                        val intent = Intent(this, HomeActivity::class.java)

                        startActivity(intent)
                    } else
                        if (username.text.toString() != "Admin"
                            || password.text.toString() != "123456"
                            && password.text.toString().isNotEmpty()
                            && username.text.toString().isNotEmpty()
                        ) {
                            username.text.clear()
                            password.text.clear()
                            errorMessageTextView.visibility = View.VISIBLE
                            errorMessageTextView.text =
                                getString(R.string.wrong_password_or_username)
                            errorMessageTextView.requestFocus()
                        }
        }

    }


//    private fun showHome() {
//        val loginActivity =
//        R.layout.activity_login = View.VISIBLE
//        second_layout.visibility = View.GONE
//    }
}
