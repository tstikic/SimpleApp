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
            errorMessageTextView.clearFocus()


            if (username.text.toString().isEmpty()) {
                errorMessageTextView.setVisibility(View.VISIBLE)
                errorMessageTextView.error = "You need to enter username"
            } else
                if (password.text.toString().isEmpty()) {
                    errorMessageTextView.setVisibility(View.VISIBLE)
                    errorMessageTextView.error = "You need to enter password"

                } else
                    if (username.text.toString() == "Admin" && password.text.toString() == "123456") {
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
                            errorMessageTextView.clearFocus()
                            errorMessageTextView.setVisibility(View.VISIBLE)
                            errorMessageTextView.error = "Wrong password or username"
                        }
        }

    }


//    private fun showHome() {
//        val loginActivity =
//        R.layout.activity_login = View.VISIBLE
//        second_layout.visibility = View.GONE
//    }
}
